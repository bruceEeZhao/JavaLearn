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

class NYStyleVeggiePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("NY veggie + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("NY 250 degree 33 minutes");
    }
}

class ChicagoStyleVeggiePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("Chicago veggie + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("Chicago 250 degree 33 minutes");
    }
}