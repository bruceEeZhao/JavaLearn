package decorator;

public abstract class Beverage {
    String description = "Unkown Bervage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
