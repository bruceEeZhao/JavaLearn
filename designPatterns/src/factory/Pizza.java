package factory;

public abstract class Pizza {

    public abstract void prepare();

    public abstract void bake();

    public void cut() {
        System.out.println("cut");
    }

    public void box() {
        System.out.println("box");
    }
}

