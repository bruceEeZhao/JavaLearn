package observer.push;

public class CurrentCondition implements Observer, DisplayElement {
    private float temperature;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        display();
    }

    @Override
    public void display() {
        System.out.println("CurrentCondition: " + "temperature is " + temperature + ".C");
    }


}
