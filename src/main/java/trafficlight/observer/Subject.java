package trafficlight.observer;

import java.util.ArrayList;

public class Subject {

    public /*static*/ ArrayList<Observer> observerCollection = new ArrayList<>();

    /*public static <T extends Observer> void addObserver(T observerToAdd){
        observerCollection.add(observerToAdd);
    }*/
    public /*static*/ void addObserver(Observer observerToAdd){
        this.observerCollection.add(observerToAdd);
    }
    public /*static*/ void removeObserver(Observer observerToRemove){
        this.observerCollection.remove(observerToRemove);
    }
    public void notifyObservers(/*String color*/){
        for(Observer observer : observerCollection){
            observer.update(this);
        }
    }
}
