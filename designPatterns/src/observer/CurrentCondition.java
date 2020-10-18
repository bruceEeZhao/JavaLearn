package observer;

public class CurrentCondition implements Observer, DisplayElement {
    private float temperature;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
    }

    @Override
    public void display() {
        System.out.println("temperature is " + temperature + ".C");
    }


}
