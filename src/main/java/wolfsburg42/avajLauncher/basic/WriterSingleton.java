package main.java.wolfsburg42.avajLauncher.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WriterSingleton {

    private static volatile WriterSingleton instance;
    public final static String fileToWrite = "simulation.txt";
    private static FileWriter writer = null;
    private static List<String> queue;

    private WriterSingleton() {
        queue = new LinkedList<>();
    }

    public static WriterSingleton getInstance() {
        if (instance == null){
            synchronized (WriterSingleton.class) {
                if (instance == null) {
                    instance = new WriterSingleton();
                }
            }
        }
        return instance;
    }
    
    public void addToQueue(String message) {
        queue.add(message);
    }

    public void writeInFile() throws IOException {
        if (writer == null)
            writer = new FileWriter(fileToWrite);
        for (String line : queue)
            writer.write(line);
        queue.clear();
    }

    public void closeFile() throws IOException {
        writer.close();
    }
    
} 
