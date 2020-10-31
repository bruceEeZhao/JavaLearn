package multithread;

public class ThreadStatus implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("1." + Thread.currentThread().getName() + " status is " + Thread.currentThread().getState());
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2." + Thread.currentThread().getName() + " status is " + Thread.currentThread().getState());
            System.out.println(Thread.currentThread().getName() + " number = " + i);
        }
    }

    public void printStatus(Thread t) {
        System.out.println(t.getName() + " status is " + t.getState());
    }
    public static void main(String[] args) {
        ThreadStatus threadStatus = new ThreadStatus();
        Thread t = new Thread(threadStatus);
        threadStatus.printStatus(t);
        t.start();
        threadStatus.printStatus(t);
        try {
            for (int i = 0; i < 10; i++) {
                threadStatus.printStatus(t);
                //Thread.sleep(80);
            }
            t.join();
            threadStatus.printStatus(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
