package main.java.wolfsburg42.avajLauncher.tower;
import main.java.wolfsburg42.avajLauncher.basic.Coordinates;

public class WeatherProvider {
    private static volatile WeatherProvider instance;

    private String[] weather = new String[] {"SNOW", "RAIN", "SUN", "FOG"};
    
    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        if (instance == null){
            synchronized (WeatherProvider.class) {
                if (instance == null) {
                    instance = new WeatherProvider();
                }
            }
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        
        // seems like here we should make some algorythm of random weather
        return weather[(p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude())%3];
    }

}