package multithread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class SyncAtomicLongadder {
    static Long count1 = 0L;
    static AtomicInteger count2 = new AtomicInteger();
    static LongAdder count3 = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[1000];
        long start ,end = 0L;

        // 使用synchronized
        Object lock = new Object();
        for (int i=0; i<threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k=0; k<100000; k++)
                        synchronized (lock) {
                            count1++;
                        }
                }
            });
        }

        start = System.currentTimeMillis();
        for (Thread t: threads
             ) {
            t.start();
        }
        for (Thread t: threads
             ) {
            t.join();
        }
        end = System.currentTimeMillis();
        System.out.println("sync " + (end - start));

        // Atomic
        for (int i=0; i<threads.length; i++) {
            threads[i] = new Thread(()->{
               for (int k=0; k<100000; k++) {
                   count2.incrementAndGet();
               }
            });
        }
        start = System.currentTimeMillis();
        for (Thread t: threads
        ) {
            t.start();
        }
        for (Thread t: threads
        ) {
            t.join();
        }
        end = System.currentTimeMillis();
        System.out.println("atomic " + (end - start));


        //LongAdder
        for (int i=0; i<threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int k=0; k<100000; k++) {
                    count3.increment();
                }
            });
        }

        start = System.currentTimeMillis();
        for (Thread t: threads
        ) {
            t.start();
        }
        for (Thread t: threads
        ) {
            t.join();
        }
        end = System.currentTimeMillis();
        System.out.println("LongAdder " + (end - start));
    }
}
