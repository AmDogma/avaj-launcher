package main.java.wolfsburg42.avajLauncher.aircrafts;

import main.java.wolfsburg42.avajLauncher.basic.Coordinates;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        id = p_id;
        name = p_name;
        coordinates = p_coordinate;
    }

    public void updateConditions() {
        throw new UnsupportedOperationException("Unimplemented method 'updateConditions'");
    }

    public String getName() {
        return name;
    }
}
