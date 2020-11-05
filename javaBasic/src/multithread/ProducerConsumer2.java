package multithread;

import java.util.Random;

public class ProducerConsumer2 {
    public static void main(String[] args) {
        CubbyHole c = new CubbyHole();
        Producer2 p1 = new Producer2(c, 1);
        Producer2 p2 = new Producer2(c, 2);
        Producer2 p3 = new Producer2(c, 3);
        Consumer2 c1 = new Consumer2(c, 1);
        p1.start();
        p2.start();
        p3.start();
        c1.start();
    }
}

class CubbyHole {
    private int contents;
    private boolean available = false;
    public synchronized int get() {
        while (available == false) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        available = false;
        notifyAll();
        return contents;
    }
    public synchronized void put(int value) {
        while (available == true) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        contents = value;
        available = true;
        notifyAll();
    }
}

class Consumer2 extends Thread {
    private CubbyHole cubbyhole;
    private int number;
    public Consumer2(CubbyHole c, int number) {
        cubbyhole = c;
        this.number = number;
    }
    public void run() {
        int value = 0;
        for (;;) {
            value = cubbyhole.get();
            System.out.println("消费者 #" + this.number+ " got: " + value);
        }
    }
}

class Producer2 extends Thread {
    private CubbyHole cubbyhole;
    private int number;

    public Producer2(CubbyHole c, int number) {
        cubbyhole = c;
        this.number = number;
    }

    public void run() {
        for (;;) {
            int a = new Random().nextInt(10);
            cubbyhole.put(a);
            System.out.println("生产者 #" + this.number + " put: " + a);
        }
    }
}