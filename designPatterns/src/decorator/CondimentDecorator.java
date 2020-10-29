package decorator;

import java.util.HashMap;
import java.util.Map;

public abstract class CondimentDecorator extends Beverage{
    public abstract String getDescription();
}

class Milk extends CondimentDecorator {
    private Beverage beverage;

    // private Map<Size, Double> price = new HashMap<Size, Double>();

    public Milk(Beverage beverage) {
        this.beverage = beverage;
        /*
        setSize(beverage.getSize());

        price.put(Size.SMALL, 0.11);
        price.put(Size.MEDIUM, 0.15);
        price.put(Size.LARGE, 0.31);

         */
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        // return beverage.cost() + price.get(getSize());
        return beverage.cost() + 0.3;
    }
}

class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.2;
    }
}

class Soy extends CondimentDecorator{
    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.4;
    }
}

class Whip extends CondimentDecorator{
    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.3;
    }
}