package factory;

public class VeggiePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("veggie + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("250 degree 33 minutes");
    }
}
