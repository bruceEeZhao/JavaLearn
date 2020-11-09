package factory;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStoreAbstr nyStore = new NYPizzaStore();
        PizzaStoreAbstr chicagoStore = new ChicagoPizzaStore();

        nyStore.orderPizza("cheese");

        chicagoStore.orderPizza("cheese");
    }
}
