package multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedTest {

    /**
     * 这个测试是为了测试，使用 fixedThreadPool 会导致内存溢出，使用下面的命令可以设置jvm虚拟机的参数
     * java -Xmx8m -Xms8m multithread.threadpool.FixedTest
     *
     * 导致内存溢出的原因是fixedThreadPool，是使用LinkedBlockingQueue实现的，会不断的添加线程
     * public static ExecutorService newFixedThreadPool(int nThreads) {
     *         return new ThreadPoolExecutor(nThreads, nThreads,
     *                                       0L, TimeUnit.MILLISECONDS,
     *                                       new LinkedBlockingQueue<Runnable>());
     *     }
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(5);
        for (int i=0; i<Integer.MAX_VALUE; i++) {
            final int ii = i;
            e.execute(()->System.out.println(Thread.currentThread().getName() + " execute " + ii));
        }
    }
}
