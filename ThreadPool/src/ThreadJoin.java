import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        //1、定义两个线程，保存在threads中
        List<Thread> threads = IntStream.range(1, 3).mapToObj(ThreadJoin::create).collect(toList());
        //2、启动这两个线程
        threads.forEach(Thread::start);


        //3、执行这两个线程的join方法
        for (Thread thread : threads){
            thread.join();
        }
        //4、main线程循环输出
        executeThread();
    }


    private static Thread create(int seq){
        return new Thread(ThreadJoin::executeThread,String.valueOf(seq));
    }

    private static void executeThread() {
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + "#" + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
