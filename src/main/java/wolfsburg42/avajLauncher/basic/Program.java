package main.java.wolfsburg42.avajLauncher.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import main.java.wolfsburg42.avajLauncher.aircrafts.AircraftFactory;
import main.java.wolfsburg42.avajLauncher.aircrafts.Flyable;
import main.java.wolfsburg42.avajLauncher.exceptions.ScenarioFileException;
import main.java.wolfsburg42.avajLauncher.tower.WeatherTower;

public class Program {

    public final static String fileToWrite = "simulation.txt";
    private WeatherTower tower = new WeatherTower();
    private AircraftFactory aircraftFactory = AircraftFactory.getInstance();
    private int weatherChanges = 0;
    private Coordinates coordinates;
    private Flyable flyable;
    private String[] lines;
    private String scenarioFile;

    public Program(String p_scenarioFile) {
        scenarioFile = p_scenarioFile;
    }

    public void run() throws ScenarioFileException {
        try (BufferedReader reader = new BufferedReader(new FileReader(scenarioFile))) {
            try (FileWriter writer = new FileWriter(fileToWrite)) {
                WriteToFile.getInstance().setFileStream(writer);
                weatherChanges = Integer.parseInt(reader.readLine());
                if (weatherChanges < 1) {
                    throw new ScenarioFileException("ScenarioFileException: weatherChanges < 1");
                }
                for(String line = reader.readLine(); line != null; line = reader.readLine()) {
                    lines = line.split(" ");
                    if (lines.length != 5)
                        throw new ScenarioFileException("ScenarioFileException: lines.length != 5");
                    coordinates = new Coordinates(
                        Integer.parseInt(lines[2]), Integer.parseInt(lines[3]), Integer.parseInt(lines[4]));
                    flyable = aircraftFactory.newAircraft(lines[0], lines[1], coordinates);

                    flyable.registerTower(tower);
                    if (coordinates.getHeight() != 0) {
                        tower.register(flyable);
                    }
                }
                for(; weatherChanges > 0; --weatherChanges) {
                    tower.changeWeather();
                }
            } catch(NumberFormatException e) {
                throw new ScenarioFileException("ScenarioFileException: " + e.getMessage(), e);
            } 
        } catch (IOException e) {
            throw new ScenarioFileException("ScenarioFileException: " + e.getMessage(), e);
        }  catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
