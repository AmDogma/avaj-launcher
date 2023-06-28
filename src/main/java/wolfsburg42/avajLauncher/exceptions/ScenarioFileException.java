package main.java.wolfsburg42.avajLauncher.exceptions;

public class ScenarioFileException extends Exception {
    
    public ScenarioFileException() {
        super();
    }

    public ScenarioFileException(String message) {
        super("ScenarioFileException: " + message);
    }

    public ScenarioFileException(String message, Throwable cause) {
        super("ScenarioFileException: " + message, cause);
    }

    public ScenarioFileException(Throwable cause) {
        super(cause);
    }
}
