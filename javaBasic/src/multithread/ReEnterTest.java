package multithread;

import java.util.concurrent.Callable;

public class ReEnterTest {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }

    public synchronized void m2() {
        System.out.println(Thread.currentThread().getName() + " m2 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 end");
    }

    public static void main(String[] args) {
        ReEnterTest r = new ReEnterTest();
        Runnable c = new Runnable() {
            @Override
            public void run() {
                r.m1();
            }
        };

        new Thread(c).start();
        new Thread(c).start();
    }
}
