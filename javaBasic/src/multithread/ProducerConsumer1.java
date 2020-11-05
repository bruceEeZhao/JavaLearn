package multithread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ProducerConsumer1 {
    public static void main(String[] args) {
        WareHouse wareHouse = new WareHouse();

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i=0; i<10; i++) {
            threads.add(new Thread(new Producer(wareHouse)));
        }

        for (int i=0; i<2; i++) {
            threads.add(new Thread(new Consumer(wareHouse)));
        }

        for (Thread t: threads
             ) {
            t.start();
        }

    }
}

class WareHouse {
    volatile List<Integer> wareHouse = Collections.synchronizedList(new ArrayList<>());
    final int Max_length = 1000;

    synchronized void produce() {
        while (wareHouse.size() == Max_length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int a = new Random().nextInt(30);
        wareHouse.add(a);
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " produce " + a
                + " wareHouse size is " + wareHouse.size());
    }

    synchronized void consume() {
        //仓库已空
        while (wareHouse.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int a = wareHouse.remove(0);
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " get " + a
                + " wareHouse size is " + wareHouse.size());
    }

    synchronized int getSize() {
        return wareHouse.size();
    }
}

class Producer implements Runnable {
    private WareHouse wareHouse;

    Producer(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        while (true) {
            wareHouse.produce();
        }
    }
}

class Consumer implements Runnable {
    private WareHouse wareHouse;
    Consumer(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        while(true) {
            wareHouse.consume();
        }
    }
}