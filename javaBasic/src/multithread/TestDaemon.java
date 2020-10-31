package multithread;

public class TestDaemon implements Runnable{
    private int number = 1000;
    @Override
    public void run() {
        while (number > 0) {
            decrease();
        }
    }

    public synchronized void decrease(){
        if (number > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + " number = " + number);
        }
    }

    public static void main(String[] args) {
        TestDaemon t = new TestDaemon();
        Thread t1 = new Thread(t, "thread1");
        Thread t2 = new Thread(t, "thread2");
        //这个案例证明了，主线程是直接退出的，但daemon线程却没有退出，也就是说，只要有一个线程存在，daemon就不会退出。
        t1.setDaemon(true);
        //t2.setDaemon(true);
        t1.start();
        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + "exit");
    }
}
