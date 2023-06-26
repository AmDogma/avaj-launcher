package main.java.wolfsburg42.avajLauncher.tower;

import java.util.LinkedList;
import java.util.List;

import main.java.wolfsburg42.avajLauncher.aircrafts.Flyable;
import main.java.wolfsburg42.avajLauncher.exceptions.LandingExeption;

public class Tower {
    private List<Flyable> observers = new LinkedList<Flyable>();

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
    }

    protected void conditionChanged() {
        for (Flyable f : observers) {
            try {
                f.updateConditions();
            } catch (LandingExeption e) {
                unregister(f);
            }
            
        }
    }
}
