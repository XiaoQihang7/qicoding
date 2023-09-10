import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin extends RecursiveTask<Integer> {

    int begin;
    int end;
    public ForkJoin( int begin, int end){
        this.begin=begin;
        this.end=end;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        System.out.println(forkJoinPool.invoke(new ForkJoin(1, 5)));
    }


    @Override
    protected Integer compute() {
        // 5, 5
        if (begin == end) {
            return begin;
        }
        // 4, 5  防止多余的拆分  提高效率
        if (end - begin == 1) {
            return end + begin;
        }
        // 1 5
        int mid = (end + begin) / 2; // 3
        ForkJoin t1 = new ForkJoin(begin, mid); // 1,3
        t1.fork();
        ForkJoin t2 = new ForkJoin(mid + 1, end); // 4,5
        t2.fork();
        return t1.join() + t2.join();
    }
}
