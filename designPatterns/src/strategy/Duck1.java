package strategy;

public abstract class Duck1 {
    public void quack() {
        System.out.println("quack");
    }

    public void swim() {
        System.out.println("I can swim");
    }

    public abstract void display();

    // 这时添加了一个飞的需求
    public void fly() {
        System.out.println("I can fly");
    }

}


class MallardDuck extends Duck1 {

    @Override
    public void display() {
        System.out.println("MallardDuck");
    }

    public static void main(String[] args) {
        MallardDuck m = new MallardDuck();
        m.quack();
        m.swim();
        m.display();
    }
}

class RedHeadDuck extends Duck1 {


    @Override
    public void display() {
        System.out.println("RedHeadDuck");
    }

    public static void main(String[] args) {
        RedHeadDuck r = new RedHeadDuck();
        r.quack();
        r.swim();
        r.display();
    }
}

class RubberDuck extends Duck1 {
    @Override
    public void quack() {
        //do nothing
    }

    @Override
    public void fly() {
        //do nothing
    }

    @Override
    public void display() {
        System.out.println("RubberDuck");
    }

    public static void main(String[] args) {
        RubberDuck r = new RubberDuck();
        r.display();
        r.quack();
        r.swim();
        r.fly();
    }
}