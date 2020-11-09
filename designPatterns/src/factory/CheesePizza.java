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

class NYStyleCheesePizza extends  Pizza {
    @Override
    public void prepare() {
        System.out.println("NY cheese + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("NY 220 degree 45 minutes");
    }
}

class ChicagoStyleCheesePizza extends  Pizza {
    @Override
    public void prepare() {
        System.out.println("Chicago cheese + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("Chicago 220 degree 45 minutes");
    }
}