package multithread;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private Lock lock = new ReentrantLock();
    private int count = 10;

    public void sell() {
        while(count > 0) {
            if (lock.tryLock()) {
                try {
                    count--;
                    System.out.println(Thread.currentThread().getName() + " count = " + count);
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            } else {
                System.out.println(Thread.currentThread().getName() + " failed to get lock ");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        ReentrantLockTest r = new ReentrantLockTest();

        for (int i=0; i<3; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    r.sell();
                }
            }));
        }

        for (Thread t: threads
             ) {
            t.start();
        }
    }
}
