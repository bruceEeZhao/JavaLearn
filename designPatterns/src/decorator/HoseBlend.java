package decorator;

import java.util.HashMap;
import java.util.Map;

public class HoseBlend extends Beverage{
    /*
    private Map<Size, Double> price = new HashMap<Size, Double>();
     */

    public HoseBlend() {
        description = "HoseBlend";
    /*
        price.put(Size.SMALL, 0.1);
        price.put(Size.MEDIUM, 0.2);
        price.put(Size.LARGE, 0.3);
    */
    }


    @Override
    public double cost() {
      //  return price.get(getSize());
        return 0.3;
    }
}
