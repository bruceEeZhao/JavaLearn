package factory;

public class GreekPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("greek + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("220 degree 50 minutes");
    }
}

class NYStyleGreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("NY greek + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("NY 220 degree 50 minutes");
    }
}

class ChicagoStyleGreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("Chicago greek + milk + flour");
    }

    @Override
    public void bake() {
        System.out.println("Chicago 220 degree 50 minutes");
    }
}