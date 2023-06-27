package main.java.wolfsburg42.avajLauncher.tower;

import java.util.LinkedList;
import java.util.List;

import main.java.wolfsburg42.avajLauncher.aircrafts.Flyable;

public class Tower {
    private List<Flyable> observers = new LinkedList<Flyable>();
    private List<Flyable> observersToDelete = new LinkedList<Flyable>();

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        observersToDelete.add(p_flyable);
    }

    protected void conditionChanged() {
        List<Flyable> observersCopy = new LinkedList<Flyable>(observers);
        for (Flyable f : observersCopy) {
            f.updateConditions();
        }
        observers.removeAll(observersToDelete);
    }
}
