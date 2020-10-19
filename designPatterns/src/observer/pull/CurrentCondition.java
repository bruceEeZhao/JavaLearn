package observer.pull;

public class CurrentCondition implements Observer, DisplayElement {
    private float temperature;
    private float humidity;

    @Override
    public void display() {
        System.out.println("CurrentCondition: temperature is " + temperature + "humidity is " + humidity);
    }

    @Override
    public void update(Subject subject) {
        // 判断subject是否是WeatherData
        if (subject instanceof  WeatherData) {
            this.temperature = ((WeatherData) subject).getTemperature();
            this.humidity = ((WeatherData) subject).getHumidity();
            display();
        }
    }
}
