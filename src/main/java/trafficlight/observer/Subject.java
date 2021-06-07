package trafficlight.observer;

import java.util.ArrayList;

public class Subject {

    public ArrayList<Observer> observerCollection = new ArrayList<>();

    public void addObserver(Observer observerToAdd){
        this.observerCollection.add(observerToAdd);
    }
    public void removeObserver(Observer observerToRemove){
        this.observerCollection.remove(observerToRemove);
    }
    public void notifyObservers(){
        for(Observer observer : observerCollection){
            observer.update();
        }
    }
}
