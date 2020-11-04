package multithread;

public class ThreadLoaclTest {
    public static void main(String[] args) {
        ThreadLocal<Person> tl = new ThreadLocal<Person>();
        new Thread(()-> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + tl.get());
        }).start();

        new Thread(()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person("zhangSan"));
        }).start();

        new Thread(()-> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person("liSi"));
            System.out.println(Thread.currentThread().getName() + tl.get());
        }).start();
    }
}

class Person {
    private String name;
    Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}