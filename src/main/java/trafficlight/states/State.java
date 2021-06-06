package trafficlight.states;

import trafficlight.observer.Observer;
import trafficlight.observer.Subject;

//TODO implement a part of the pattern here

public abstract class State extends Subject {

    public abstract State getNextState();

    public abstract String getColor();

    public String getSting(){
        return getColor();
    }

    /*
    @Override
    public void addObserver(Observer observerToAdd) {
        super.addObserver(observerToAdd);
    }
    @Override
    public void removeObserver(Observer observerToRemove) {
        super.removeObserver(observerToRemove);
    }
    @Override
    public void notifyObservers(String color) {
        super.notifyObservers();
    }
    */
}