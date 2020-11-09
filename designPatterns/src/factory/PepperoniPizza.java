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

class NYStylePepperoniPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("NY pepper + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("NY 250 degree 45 minutes");
    }
}

class ChicagoStylePepperoniPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("Chicago pepper + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("Chicago 250 degree 45 minutes");
    }
}