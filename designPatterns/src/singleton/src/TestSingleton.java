public class TestSingleton {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
            QinShiHuangT2.getQinShiHuang();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                QinShiHuangT2.getQinShiHuang();
            }
        });
        t1.start();
        t2.start();

    }
}
