package multithread;

import java.util.ArrayList;
import java.util.List;

public class VolatileShort {
    volatile int count = 0;
    /*synchronized*/ void m() {
        for (int i =0; i<10000; i++) {
            //synchronized (this) {
                count++;
           // }
        }
    }

    public static void main(String[] args) {
        VolatileShort v = new VolatileShort();
        List<Thread> threads = new ArrayList<>();

        for (int i =0; i<10; i++) {
            threads.add(new Thread(v::m));
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)-> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(v.count);
    }
}
