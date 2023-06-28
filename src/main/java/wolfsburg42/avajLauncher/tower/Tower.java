package main.java.wolfsburg42.avajLauncher.tower;

import java.util.LinkedList;
import java.util.List;

import main.java.wolfsburg42.avajLauncher.aircrafts.Flyable;
import main.java.wolfsburg42.avajLauncher.basic.WriteToFile;

public class Tower {
    private List<Flyable> observers = new LinkedList<Flyable>();
    private List<Flyable> observersToDelete = new LinkedList<Flyable>();

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        WriteToFile.getInstance().write("Tower says: " + p_flyable.getName() + " registered to weather tower.\n");
    }

    public void unregister(Flyable p_flyable) {
        observersToDelete.add(p_flyable);
        WriteToFile.getInstance().write("Tower says: " + p_flyable.getName() + " unregistered from weather tower.\n");
    }

    protected void conditionChanged() {
        List<Flyable> observersCopy = new LinkedList<Flyable>(observers);
        for (Flyable f : observersCopy) {
            f.updateConditions();
        }
        observers.removeAll(observersToDelete);
    }
}
