package main.java.wolfsburg42.avajLauncher.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import main.java.wolfsburg42.avajLauncher.aircrafts.AircraftFactory;
import main.java.wolfsburg42.avajLauncher.aircrafts.Flyable;
import main.java.wolfsburg42.avajLauncher.exceptions.ScenarioFileException;
import main.java.wolfsburg42.avajLauncher.tower.WeatherTower;

public class Program {

    private final WeatherTower tower;
    private final AircraftFactory aircraftFactory;
    private final String scenarioFile;
    private int weatherChanges;

    public Program(String p_scenarioFile) {
        scenarioFile = p_scenarioFile;
        tower = new WeatherTower();
        aircraftFactory = AircraftFactory.getInstance();
        weatherChanges = 0;
    }

    public void run() throws ScenarioFileException {
        try {
            List<String> scenarioLines = readAllLines();
            prepareToFly(scenarioLines);
            startFly();
        } catch (IOException e) {
            throw new ScenarioFileException(e.getMessage(), e);
        }
    }

    private void startFly() throws IOException {
        for(; weatherChanges > 0; --weatherChanges) {
            tower.changeWeather();
            WriterSingleton.getInstance().writeInFile();
        }
        WriterSingleton.getInstance().closeFile();
    }

    private void prepareToFly(List<String> scenarioLines) throws ScenarioFileException, IOException {
        Coordinates coordinates;
        Flyable flyable;
        String[] tokens;

        try {
            weatherChanges = Integer.parseInt(scenarioLines.get(0));
            if (weatherChanges < 1) {
                throw new ScenarioFileException("weatherChanges < 1");
            }
            for (int i = 1; i < scenarioLines.size(); i++) {
                tokens = scenarioLines.get(i).split(" ");
                if (tokens.length != 5) {
                    throw new ScenarioFileException("Invalid line format of" + scenarioLines.get(i));
                } else if (aircraftFactory.idChackMax())
                    throw new ScenarioFileException("ID == max long");
                coordinates = new Coordinates(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
                flyable = aircraftFactory.newAircraft(tokens[0], tokens[1], coordinates);

                flyable.registerTower(tower);
                if (coordinates.getHeight() != 0) {
                    tower.register(flyable);
                }
            }
        } catch (NumberFormatException e) {
            throw new ScenarioFileException(e.getMessage(), e);
        }
        WriterSingleton.getInstance().writeInFile();
    }

    private List<String> readAllLines() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(scenarioFile))) {
            return reader.lines().collect(Collectors.toList());
        }
    }
}
