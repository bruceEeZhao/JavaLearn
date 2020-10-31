package multithread;

import java.util.concurrent.*;

public class Exprience {
    //测试使用 Runnable实现多线程的类的方法
    public Thread testRunnable() {
        MythreadR m = new MythreadR();
        Thread thread = new Thread(m, "[MythreadR]");
        thread.start();
        return thread;
    }

    //测试使用thread实现多线程的类的方法
    public Thread testThread() {
        MythreadT m = new MythreadT();
        m.start();
        return m;
    }

    public Future<Integer> testCallable() {
        MythreadC m = new MythreadC();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(m);
        executorService.shutdown();
        return future;
    }

    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " start");
        Exprience e = new Exprience();

        //第一个测试用例从中可以看出，主线程会在子线程结束之前先结束
        // e.testRunnable();
        // e.testThread();

        // 测试用例2,从这个测试用例可以看出，由于使用了t1.join()主线程会在t1线程结束后结束
        Thread t1 = e.testRunnable();
        Thread t2 = e.testThread();
        Future t3 = e.testCallable();
        try {
            System.out.println("============= ticket = "+t3.get().toString());
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (ExecutionException executionException) {
            executionException.printStackTrace();
        }

        try {
            t1.join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        System.out.println(name + " end");
    }
}

class MythreadR implements Runnable {
    private int ticket = 5;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " start");
        while(true){
            System.out.println(name + " ticket = " + ticket--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ticket < 0){
                break;
            }
        }
        System.out.println(name + " end");
    }

}


class MythreadT extends Thread {
    private int ticket = 5;

    public MythreadT() {
        super("[MythreadT]");
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " start");
        while(true){
            System.out.println(name + " ticket = " + ticket--);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ticket < 0){
                break;
            }
        }
        System.out.println(name + " end");
    }
}

class MythreadC implements Callable<Integer> {
    private int ticket = 5;

    @Override
    public Integer call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name + " start");
        while(true){
            System.out.println(name + " ticket = " + ticket--);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ticket < 0){
                break;
            }
        }
        System.out.println(name + " end");

        return ticket;
    }
}