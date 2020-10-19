package observer.push;

public class StatisticDisplay implements Observer,DisplayElement {
    private float humidity;
    @Override
    public void display() {
        System.out.println("StatisticDisplay: " + "humidity is " + humidity);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.humidity = humidity;
        display();
    }
}
