package multithread;

public class SynchronizedTest {
    private int count = 10;
    private Object o = new Object();

    public synchronized void m() { //等同于在方法的代码执行时要synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + "count = " + count);
    }
    /*
    public void m() {
        synchronized (this) { //任何线程要执行下面的代码时，必须先拿到this的锁
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }
    } */

    public void m1() {
        synchronized (o) { //任何线程要执行下面的代码时，必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }
    }

    public synchronized void m2() {
        System.out.println(Thread.currentThread().getName() + " m2 start ... ");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 end ");
    }

    //非同步方法
    public void m3() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m3 ");
    }

    public void run() {
        while (count>0) {
            m();
        }
    }

    public void run1() {

    }

    public static void main(String[] args) {
        SynchronizedTest s = new SynchronizedTest();
        Runnable a = new Runnable() {
            @Override
            public void run() {
                s.run();
            }
        };
        Thread t = new Thread(a);
        Thread t1 = new Thread(a);
        t.start();
        t1.start();


        //测试同步非同步方法是否可以同时调用
        Runnable b = new Runnable() {
            @Override
            public void run() {
                s.m2();
            }
        };

        /*
        Runnable b2 = new Runnable() {
            @Override
            public void run() {
                s.m2();
            }
        };
         */

        Runnable b2 = new Runnable() {
            @Override
            public void run() {
                s.m3();
            }
        };

        new Thread(b).start();
        new Thread(b2).start();
    }
}
