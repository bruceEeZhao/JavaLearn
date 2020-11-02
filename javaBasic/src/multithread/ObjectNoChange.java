package multithread;

public class ObjectNoChange {
    /*final*/ Object o  = new Object();

    void m() {
        synchronized (o) {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ObjectNoChange o = new ObjectNoChange();

        new Thread(o::m).start();

        Thread.sleep(3000);

        Thread t2 = new Thread(o::m, "t2");
        o.o = new Object();
        t2.start();
    }
}
