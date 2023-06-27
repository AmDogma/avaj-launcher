package main.java.wolfsburg42.avajLauncher.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import main.java.wolfsburg42.avajLauncher.aircrafts.AircraftFactory;
import main.java.wolfsburg42.avajLauncher.aircrafts.Flyable;
import main.java.wolfsburg42.avajLauncher.tower.WeatherTower;

public class Program {
    public final static String fileToWrite = "simulation.txt";
    public void run(String scenarioFile) {
        WeatherTower tower = new WeatherTower();
        AircraftFactory aircraftFactory = AircraftFactory.getInstance();
        int weatherChanges = 0;


        try (BufferedReader reader = new BufferedReader(new FileReader(scenarioFile))) {
            
            weatherChanges = Integer.parseInt(reader.readLine());
            for(String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] lines = line.split(" ");
                if (lines.length != 5)
                    throw new Exception("AAAAAAAAAAAAA");  // own except
                Coordinates coordinates = new Coordinates(
                    Integer.parseInt(lines[2]), Integer.parseInt(lines[3]), Integer.parseInt(lines[4]));
                
                Flyable flyable = aircraftFactory.newAircraft(lines[0], lines[1], coordinates);

                flyable.registerTower(tower);
                if (coordinates.getHeight() != 0)
                    tower.register(flyable);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } 

        //exceptions will be on screen input 
        
        try (FileWriter writer = new FileWriter(fileToWrite)) {
            //initialize logger
            for(; weatherChanges > 0; --weatherChanges) {
                tower.changeWeather();
            }
        } catch (IOException e) {
            
        }
    }
}
