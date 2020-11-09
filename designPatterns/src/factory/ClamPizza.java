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

class NYStyleClamPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("NY clam + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("NY 250 degree 40 minutes");
    }
}

class ChicagoStyleClamPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("Chicago clam + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("Chicago 250 degree 40 minutes");
    }
}