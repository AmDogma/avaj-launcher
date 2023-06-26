package main.java.wolfsburg42.avajLauncher.aircrafts;

import main.java.wolfsburg42.avajLauncher.basic.Coordinates;
import main.java.wolfsburg42.avajLauncher.exceptions.LandingExeption;
import main.java.wolfsburg42.avajLauncher.tower.WeatherProvider;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions() {
        String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);
        if (weather == "SNOW") {
            coordinates.moveHeight(-15);
        } else if (weather == "RAIN") {
            coordinates.moveHeight(-5);
        } else if (weather == "FOG") {
            coordinates.moveHeight(-3);
        } else { // 
            coordinates.moveLongitude(2);
            coordinates.moveHeight(4);
        }
    }

    
}
