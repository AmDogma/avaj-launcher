package main.java.wolfsburg42.avajLauncher.aircrafts;

import main.java.wolfsburg42.avajLauncher.basic.Coordinates;
import main.java.wolfsburg42.avajLauncher.exceptions.ScenarioFileException;

public class AircraftFactory {
    private static volatile AircraftFactory instance;
    private long id = 0;
    
    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (instance == null){
            synchronized (AircraftFactory.class) {
                if (instance == null) {
                    instance = new AircraftFactory();
                }
            }
        }
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws ScenarioFileException {
        switch (p_type) {
            case "Helicopter":
                return new Helicopter(++id, p_type + "#" + p_name + "(" + id + ")", p_coordinates);
            case "Baloon":
                return new Baloon(++id, p_type + "#" + p_name + "(" + id + ")", p_coordinates);
            case "JetPlane":
                return new JetPlane(++id, p_type + "#" + p_name + "(" + id + ")", p_coordinates);
            default:
                throw new ScenarioFileException("Aircraft type is wrong!");
        }
    }

    public boolean idChackMax() {
        return id == Long.MAX_VALUE;
    }

}