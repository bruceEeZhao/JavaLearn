package multithread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private static final int Max_AVALIABLE = 3;
    private final Semaphore semaphore = new Semaphore(Max_AVALIABLE);

    private ArrayList<Map<Object, Integer>> objects = new ArrayList<>();
    private boolean[] used = new boolean[Max_AVALIABLE];

    // 停车
    public int park(Object o) throws InterruptedException {
        semaphore.acquire();
        return park1(o);
    }

    private synchronized int park1(Object o) {
        int ret = -1;

        for (int i=0; i<Max_AVALIABLE; i++) {
            if (!used[i]) {
                used[i] = true;
                Map<Object, Integer> parkpos= new HashMap<>();
                parkpos.put(o, i);
                objects.add(parkpos);
                ret = i;
                System.out.println(Thread.currentThread().getName() + o + " park in the " + ret);
                break;
            }
        }

        return ret;
    }

    // 离开
    public synchronized int leave(Object o) {
        int ret = leave1(o);
        if (ret >= 0) {
            semaphore.release();
        }
        return ret;
    }
    private synchronized int leave1(Object o) {
        int ret = -1;

        for (Map m: objects
             ) {
            if (m.containsKey(o)) {
                Object v = m.get(o);
                if (v instanceof Integer) {
                    used[(Integer) v] = false;
                    ret = (Integer) v;
                    Map<Object, Integer> parkpos= new HashMap<>();
                    parkpos.put(o, ret);
                    objects.remove(parkpos);
                    System.out.println(Thread.currentThread().getName() + o + " leave the park " + ret);
                    break;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        SemaphoreTest s = new SemaphoreTest();
        ArrayList<Car> cars = new ArrayList<>();

        for (int i=0; i<10; i++) {
            Car c = new Car(i, s);
            cars.add(c);
        }

        for (Car car: cars
             ) {
            new Thread(car).start();
        }
    }
}

class Car implements Runnable{
    // 车牌号
    private int carNumber;
    private SemaphoreTest s;

    public Car(int carNumber, SemaphoreTest s) {
        this.carNumber = carNumber;
        this.s = s;
    }

    public int getCarNumber() {
        return carNumber;
    }

    @Override
    public void run() {
        try {
            s.park(this);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        s.leave(this);
    }

    @Override
    public String toString() {
        return " Car{" +
                "carNumber=" + carNumber +
                '}';
    }
}
