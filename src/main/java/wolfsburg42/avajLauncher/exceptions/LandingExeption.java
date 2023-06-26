package main.java.wolfsburg42.avajLauncher.exceptions;

public class LandingExeption extends Exception {
    
    public LandingExeption() {
        super();
    }

    public LandingExeption(String message) {
        super(message);
    }

    public LandingExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public LandingExeption(Throwable cause) {
        super(cause);
    }
}
