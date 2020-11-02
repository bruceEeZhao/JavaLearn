package multithread;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class VolatileTest {
    /*volatile*/ boolean running = true;

    public void m() {
        System.out.println("m start");
        while (running) {

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        VolatileTest v = new VolatileTest();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                v.m();
            }
        };

        new Thread(r).start();

        try {
            Thread.sleep(1000);
            v.running = false;
            Thread.sleep(1000);
            System.out.println(v.running);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
