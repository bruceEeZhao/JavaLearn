package observer.pull;

public class ForcastDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void display() {
        System.out.println("ForcastDisplay: temperature is " + temperature
                + "humidity is " + humidity
                + "pressure is " + pressure);
    }

    @Override
    public void update(Subject subject) {
        // 判断subject是否是WeatherData
        if (subject instanceof  WeatherData) {
            this.temperature = ((WeatherData) subject).getTemperature();
            this.humidity = ((WeatherData) subject).getHumidity();
            this.pressure = ((WeatherData) subject).getPressure();
            display();
        }
    }
}
