package strategy;

public abstract class Duck2 {
    private FlyBegavior flyBegavior;
    private QuackBehavior quackBehavior;

    public Duck2(QuackBehavior quackBehavior, FlyBegavior flyBegavior) {
        this.flyBegavior = flyBegavior;
        this.quackBehavior = quackBehavior;
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("I can siwm");
    }

    public abstract void display();

    public void performFly() {
        flyBegavior.fly();
    }
}


class MallardDuck2 extends Duck2 {
    public MallardDuck2() {
        super(new Quack(), new FlyWithWings());
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }

    public static void main(String[] args) {
        MallardDuck2 m = new MallardDuck2();
        m.display();
        m.performFly();
        m.performQuack();
        m.swim();
    }
}
