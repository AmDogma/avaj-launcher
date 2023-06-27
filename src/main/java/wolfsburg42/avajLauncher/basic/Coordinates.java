package main.java.wolfsburg42.avajLauncher.basic;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) throws Exception {
        if (p_longitude < 0 || p_latitude < 0 || p_height > 100)
            throw new Exception("BAD COORDINATES");    /// make own exception
        longitude = p_longitude;
        latitude = p_latitude;
        height = p_height;
    }
    
    public int getLongitude(){
        return longitude;
    }

    public int getLatitude(){
        return latitude;
    }

    public int getHeight(){
        return height;
    }

    public void moveLongitude(int distance){
        longitude += distance;
    }

    public void moveLatitude(int distance){
        latitude += distance;
    }

    public void moveHeight(int distance) {
        height += distance;
        if (height > 100)
            height = 100;
        else if (height < 0)
            height = 0;
    }
}
