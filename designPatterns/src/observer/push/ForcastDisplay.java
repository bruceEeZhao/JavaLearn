package observer.push;

public class ForcastDisplay implements Observer,DisplayElement {
    private float pressure;

    @Override
    public void display() {
        System.out.println("ForcastDisplay: " + "pressure is " + pressure);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.pressure = pressure;
        display();
    }
}
