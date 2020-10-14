package strategy;

public interface FlyBegavior {
    public void fly();
}

class FlyWithWings implements  FlyBegavior {

    @Override
    public void fly() {
        System.out.println("I can Fly");
    }
}

class FlyNoWay implements FlyBegavior {
    @Override
    public void fly() {
        System.out.println("can't fly");
    }
}