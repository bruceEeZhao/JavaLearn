package decorator;

public class HoseBlend extends Beverage{
    public HoseBlend() {
        description = "HoseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
