package factory;

public class PepperoniPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("pepper + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("250 degree 45 minutes");
    }
}
