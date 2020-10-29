package decorator;

public abstract class Beverage {
    String description = "Unkown Bervage";

    /*
    public enum Size {SMALL, MEDIUM, LARGE};
    Size size = Size.SMALL;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
     */

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
