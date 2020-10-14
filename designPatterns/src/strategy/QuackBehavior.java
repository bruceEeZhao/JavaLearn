package strategy;

public interface QuackBehavior {
    public void quack();
}


class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack");
    }
}

class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("squeak");
    }
}

class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("muteQuack");
    }
}