package main.java.wolfsburg42.avajLauncher.aircrafts;

import main.java.wolfsburg42.avajLauncher.basic.Coordinates;
import main.java.wolfsburg42.avajLauncher.basic.WriteToFile;
import main.java.wolfsburg42.avajLauncher.tower.WeatherProvider;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions() {
        String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);
        if (weather.equals("SNOW")) {
            coordinates.moveHeight(-15);
            WriteToFile.getInstance().write(super.name + ": It's snowing. We're gonna crash.\n");
        } else if (weather.equals("RAIN")) {
            coordinates.moveHeight(-5);
            WriteToFile.getInstance().write(super.name + ": Damn you rain! You messed up my baloon.\n");
        } else if (weather.equals("FOG")) {
            coordinates.moveHeight(-3);
            WriteToFile.getInstance().write(super.name + ": I'm getting a little low. I hope my ass doesn't get fried!\n");
        } else {
            coordinates.moveLongitude(2);
            coordinates.moveHeight(4);
            WriteToFile.getInstance().write(super.name + ": Let's enjoy the good weather and take some pics.\n");
        }
        if (coordinates.getHeight() == 0) {
            WriteToFile.getInstance().write(super.name + " landing.\n");
            weatherTower.unregister(this);
        }
    }

    
}
