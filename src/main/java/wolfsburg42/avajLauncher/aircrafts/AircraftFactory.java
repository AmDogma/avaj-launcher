package main.java.wolfsburg42.avajLauncher.aircrafts;

import main.java.wolfsburg42.avajLauncher.basic.Coordinates;

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

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        switch (p_type) {
            case "Helicopter":
                return new Helicopter(++id, p_name, p_coordinates);
            case "Baloon":
                return new Baloon(++id, p_name, p_coordinates);
            case "JetPlane":
                return new JetPlane(++id, p_name, p_coordinates);
            default:

                //own exeption for bonus


                //delete
                System.out.println("\u001B[31mEXEPTION!\u001B[0m");
                return null;
        }
    }

}