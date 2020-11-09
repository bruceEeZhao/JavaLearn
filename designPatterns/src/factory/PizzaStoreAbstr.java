package factory;

public abstract class PizzaStoreAbstr {
    Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);

        if (pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }

        return pizza;
    }

    abstract Pizza createPizza(String type);
}
