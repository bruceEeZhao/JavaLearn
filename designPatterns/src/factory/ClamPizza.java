package factory;

public class ClamPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("clam + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("250 degree 40 minutes");
    }
}
