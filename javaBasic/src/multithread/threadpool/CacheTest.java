package multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheTest {

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i=0; i < 10; i++) {
            final int ii = i;
            cachedThreadPool.execute(()->System.out.println("线程名称"+Thread.currentThread().getName() + "执行 " + ii));
        }
    }
}
