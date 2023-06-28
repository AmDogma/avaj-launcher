package main.java.wolfsburg42.avajLauncher.aircrafts;

import main.java.wolfsburg42.avajLauncher.basic.Coordinates;
import main.java.wolfsburg42.avajLauncher.basic.WriteToFile;
import main.java.wolfsburg42.avajLauncher.tower.WeatherProvider;

public class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions() {
        String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);
        if (weather.equals("SNOW")) {
            coordinates.moveHeight(-7);
            WriteToFile.getInstance().write(super.name + ": OMG! Winter is coming!\n");
        } else if (weather.equals("RAIN")) {
            coordinates.moveLatitude(2);
            WriteToFile.getInstance().write(super.name + ": It's raining. Better watch out for lightings.\n");
        } else if (weather.equals("FOG")) {
            coordinates.moveLatitude(1);
            WriteToFile.getInstance().write(super.name + ": Grey color calms me down.\n");
        } else {
            coordinates.moveLatitude(10);
            coordinates.moveHeight(2);
            WriteToFile.getInstance().write(super.name + ": Son this is the sun.\n");
        }
        if (coordinates.getHeight() == 0) {
            WriteToFile.getInstance().write(super.name + " landing.\n");
            weatherTower.unregister(this);
        }
    }

    
}
