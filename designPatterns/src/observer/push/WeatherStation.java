package observer.push;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentCondition c = new CurrentCondition();
        StatisticDisplay s = new StatisticDisplay();
        ForcastDisplay f = new ForcastDisplay();

        // 注册Observer
        weatherData.registerObserver((Observer)c);
        weatherData.registerObserver((Observer)s);
        weatherData.registerObserver((Observer)f);

        weatherData.measurementsChanged((float)1.1, 1,2);

        System.out.println("-----------------------------------");
        // 删除一个observer，再查看现在的情况
        weatherData.removeObserver((Observer)c);
        weatherData.measurementsChanged((float)5.5, 2,3);

    }
}
