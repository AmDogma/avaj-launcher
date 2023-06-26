package main.java.wolfsburg42.avajLauncher.tower;

import main.java.wolfsburg42.avajLauncher.basic.Coordinates;

public class WeatherTower extends Tower {
    
    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        super.conditionChanged();
    }
    
}
