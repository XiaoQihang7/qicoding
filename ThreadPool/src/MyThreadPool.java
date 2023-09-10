import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class MyThreadPool {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(2, 1000, TimeUnit.MILLISECONDS, 10,
                (queue,task)-> {
                    queue.offer(task,1000,TimeUnit.MILLISECONDS);
//                    System.out.println("放弃多余任务");
//                    throw new RuntimeException("任务执行失败");
//                    task.run(); //调用者自己执行
                }
        );

        for(int i=0;i<15;i++){
            int j=i; //由于i是变化的，lambda表达式无法直接获取
            threadPool.excute(()-> {
                try {
                    Thread.sleep(10000L); //便于测试，任务个数超出了核心线程数+阻塞线程数；睡眠没有消费->陷入等待
                    //优化：设计拒绝策略；阻塞队列添加时会出现死等，可以设置一个带超时时间的阻塞添加
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(j);
            });
        }
    }

}

//线程池
class ThreadPool{
    //任务队列
    private BlockingQueue<Runnable> taskQueue;

    //线程集合
    private HashSet<Worker> workers = new HashSet<>();
    //核心线程数
    private int coreSize;
    //获取任务的超时时间及单位
    private long timeout;
    private TimeUnit timeUnit;

    //拒绝策略
    private RejectPolicy<Runnable> rejectPolicy;

    public ThreadPool(int coreSize, long timeout, TimeUnit timeUnit,int queueCapcity,RejectPolicy<Runnable> rejectPolicy) {
        this.taskQueue = new BlockingQueue<>(queueCapcity);
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.rejectPolicy=rejectPolicy;
    }

    public void excute(Runnable task){
        //当任务数没有超过 coreSize 时，直接交给Worker对象执行；超过则加入阻塞队列
        synchronized(workers){
            if (workers.size()<coreSize){
                Worker worker = new Worker(task);
                System.out.println("新增worker"+": "+worker+"  ："+task);
                workers.add(worker);
                worker.start();
            }else {
//                boolean offer = taskQueue.offer(task, timeout, timeUnit);//带超时的加入,超时后不阻塞开始执行任务
//                System.out.println("加入任务队列"+offer);
//                taskQueue.put(task);
                //拒绝策略有很多种
                //如上的，1、死等；2、带超时的等待
                //3、让调用者放弃任务执行 (什么都不写即放弃)
                //4、让调用者抛出异常 （throw）
                //5、让调用者自己执行任务
               taskQueue.tryput(rejectPolicy,task);
            }
        }
    }
    //工作线程
    class Worker extends Thread{
        private Runnable task;
        public Worker(Runnable task){
            this.task=task;
        }

        @Override
        public void run() {
            //执行任务
            //1、当任务task不为null时，执行
            //2、当任务task执行完成后，查看阻塞队列中是否存在任务，存在则继续执行
            //使用take获取任务，会发现线程创建的线程执行完任务也不会停止
            //这是一种策略：不断从生产者或阻塞队列获取任务去执行
            //可以使用之前设置的poll超时等待策略，没有任务返回null，remove这个线程
//            while(task!=null||(task=taskQueue.take())!=null){
            while(task!=null||(task=taskQueue.poll(timeout,timeUnit))!=null){
                try{
                    System.out.println("执行任务:"+task);
                    task.run();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    task=null;
                }
            }
            synchronized(workers){
                System.out.println("移除线程："+this);
                workers.remove(this);
            }
        }
    }
}

class BlockingQueue<T>{
    //1、任务队列
    Deque<T> queue=new ArrayDeque<>();

    //2、锁
    private final ReentrantLock lock = new ReentrantLock();

    //3、消费者条件变量
    Condition emptySetWait = lock.newCondition();
    //4、生产者条件变量
    Condition fullSetWait = lock.newCondition();

    //5、容量
    private int capcity;

    public BlockingQueue(int queueCapcity) {
        this.capcity=queueCapcity;
    }

    //阻塞获取
    public T take(){
        lock.lock();
        try {
            while (queue.isEmpty()){
                try {
                    emptySetWait.await();//任务为空，阻塞(这个等待是不限时等待，可优化为带超时的等待)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            fullSetWait.signal();//生产者可生产任务了
            return t;
        }finally {
            lock.unlock();
        }
    }

    //阻塞添加
    public void put(T element){
        lock.lock();
        try {
            while (queue.size()==capcity){
                try {
                    System.out.println("等待加入任务队列..."+element);
                    fullSetWait.await(); //任务满，阻塞
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("加入任务队列"+": "+element);
            queue.addLast(element);
            emptySetWait.signal(); //有任务出现，消费者可以消费任务了
        }finally {
            lock.unlock();
        }
    }

    //带超时的阻塞获取;;尝试获取锁，超时获取不到直接放弃，不进入阻塞队列
    public T poll(long timeout, TimeUnit timeUnit){
        lock.lock();
        try {
            //将timeout统一转换为纳秒
            long nanos = timeUnit.toNanos(timeout);
            while (queue.isEmpty()){
                try {
                    //返回的是剩余时间
                    if (nanos<=0) return null;
                    nanos = emptySetWait.awaitNanos(nanos);//防止没等够就将其唤醒，所以下次只需等待剩余时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            fullSetWait.signal();//生产者可生产任务了
            return t;
        }finally {
            lock.unlock();
        }
    }

    //带超时的阻塞添加
    public boolean offer(T task,long timeout,TimeUnit timeUnit){
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeout);
            while (queue.size()==capcity){
                try {
                    System.out.println("等待加入任务队列..."+task);
                    if (nanos<=0) return false;
                    nanos=fullSetWait.awaitNanos(nanos);//任务为空，阻塞(这个等待是不限时等待，可优化为带超时的等待)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("加入任务队列"+": "+task);
            queue.addLast(task);
            emptySetWait.signal();//生产者可生产任务了
            return true;
        }finally {
            lock.unlock();
        }
    }

    //获取大小
    public int size(){
        lock.lock();
        try{
            return queue.size();
        }finally {
            lock.unlock();
        }
    }

    public void tryput(RejectPolicy<T> rejectPolicy, T task) {
        lock.lock();
        try {
            if (queue.size()==capcity){
                rejectPolicy.reject(this,task);
            }else {
                System.out.println("加入任务队列" + ": " + task);
                queue.addLast(task);
                emptySetWait.signal();//生产者可生产任务了
            }
        }finally {
            lock.unlock();
        }
    }
}
