package factory;

public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("cheese + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("220 degree 45 minutes");
    }
}
