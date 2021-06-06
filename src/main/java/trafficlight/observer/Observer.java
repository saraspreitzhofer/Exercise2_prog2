package trafficlight.observer;

public interface Observer {

    //löst Aktualisierung des GUIs aus
    //public void update(String color);
    public void update(Object o);
}
