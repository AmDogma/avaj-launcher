package main.java.wolfsburg42.avajLauncher.coordinates;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) {
        longitude = p_longitude;
        latitude = p_latitude;
        height = p_height;
    }
    
    public int getLongitude(){
        return longitude;
    }

    public int getlatitude(){
        return latitude;
    }

    public int getheight(){
        return height;
    }
}
