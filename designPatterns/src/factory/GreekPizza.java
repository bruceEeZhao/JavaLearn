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
