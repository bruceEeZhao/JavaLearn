package decorator;

public class CoffeShop {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        Beverage beverage2 = new HoseBlend();
        beverage2 = new Soy(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        /*
        Beverage beverage3 = new HoseBlend();
        beverage3.setSize(Beverage.Size.MEDIUM);
        beverage3 = new Milk(beverage3);
        System.out.println("Cup Size " + beverage3.getSize() + " " + beverage3.getDescription() + " $" + beverage3.cost());

        Beverage beverage4 = new HoseBlend();
        beverage4.setSize(Beverage.Size.LARGE);
        beverage4 = new Milk(beverage4);
        System.out.println("Cup Size " + beverage4.getSize() + " " + beverage4.getDescription() + " $" + beverage4.cost());

         */
    }
}
