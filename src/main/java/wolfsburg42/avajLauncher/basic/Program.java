package main.java.wolfsburg42.avajLauncher.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import main.java.wolfsburg42.avajLauncher.aircrafts.AircraftFactory;
import main.java.wolfsburg42.avajLauncher.aircrafts.Flyable;
import main.java.wolfsburg42.avajLauncher.tower.WeatherTower;

public class Program {
    public void run(String scenarioFile) throws Exception {
        try (FileWriter writer = new FileWriter("simulation.txt");
            BufferedReader reader = new BufferedReader(new FileReader(scenarioFile))) {
            //initialize logger 
            
            String lines[];
            int weatherChanges = Integer.parseInt(reader.readLine());
            WeatherTower tower = new WeatherTower();
            AircraftFactory aircraftFactory = AircraftFactory.getInstance();

            for(lines = reader.readLine().split(" "); lines != null; lines = reader.readLine().split(" ")) {
                if (lines.length != 5)
                    throw new Exception("AAAAAAAAAAAAA");
                Coordinates coordinates = new Coordinates(
                    Integer.parseInt(lines[2]), Integer.parseInt(lines[3]), Integer.parseInt(lines[4]));
                Flyable flyable = aircraftFactory.newAircraft(lines[0], lines[1], coordinates);

                flyable.registerTower(tower);

                tower.register(flyable);

            }

            for(; weatherChanges > 0; --weatherChanges) {
                tower.changeWeather();
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
