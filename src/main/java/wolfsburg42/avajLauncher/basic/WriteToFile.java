package main.java.wolfsburg42.avajLauncher.basic;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    private static volatile WriteToFile instance;

    private static FileWriter writer = null;

    private WriteToFile() {}

    public static WriteToFile getInstance() {
        if (instance == null){
            synchronized (WriteToFile.class) {
                if (instance == null) {
                    instance = new WriteToFile();
                }
            }
        }
        return instance;
    }

    public void setFileStream(FileWriter p_writer) {
        writer = p_writer;
    }
    
    public void write(String message)  {
        if (writer != null)
            try {
                writer.write(message);
            } catch (IOException e) {
                e.printStackTrace();
            } 
    }
    
} 
