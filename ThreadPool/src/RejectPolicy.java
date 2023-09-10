//拒绝策略
public interface RejectPolicy<T> {

    void reject(BlockingQueue<T> tBlockingQueue, T task);

}
