package multithread;

public class ErrorTest {
    int count = 0;
    public synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start ");
        while (true) {
            count ++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 5) {
//                try {
                    int i = 1 / 0; //此处抛出异常，要想不释放锁，可以对异常进行捕获
                    System.out.println(i);
//                } catch (Exception e) {
//                    System.out.println(e.toString());
//                }
            }
        }
    }

    public static void main(String[] args) {
        ErrorTest e = new ErrorTest();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                e.m();
            }
        };

        new Thread(r).start();
        new Thread(r).start();
    }
}
