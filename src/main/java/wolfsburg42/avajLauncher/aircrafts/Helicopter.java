package main.java.wolfsburg42.avajLauncher.aircrafts;

import main.java.wolfsburg42.avajLauncher.basic.Coordinates;
import main.java.wolfsburg42.avajLauncher.tower.WeatherProvider;

public class Helicopter extends Aircraft {

    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions() {
        String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);
        if (weather.equals("SNOW")) {
            coordinates.moveHeight(-12);
        } else if (weather.equals("RAIN")) {
            coordinates.moveLongitude(5);
        } else if (weather.equals("FOG")) {
            coordinates.moveLongitude(1);
        } else {
            coordinates.moveLongitude(10);
            coordinates.moveHeight(2);
        }
        if (coordinates.getHeight() == 0) {
            weatherTower.unregister(this);
        }
    }

    
}
