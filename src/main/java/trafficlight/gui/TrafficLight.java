package trafficlight.gui;

import trafficlight.observer.Observer;

import java.awt.*;

public class TrafficLight extends Light implements Observer{

    TrafficLight(Color color) {
        super(color);
    }

    public void turnOn(boolean a) {
        isOn = a;
        repaint();
    }

    public boolean isOn() {
        return isOn;
    }

    //TODO implement a part of the pattern here

    @Override
    public void update() {
        if(isOn()){
            turnOn(false);
        } else{
            turnOn(true);
        }
        //turnOn(!this.isOn());
    }

    /*@Override
    public void update(Observer color) {
        TrafficLightCtrl tlc = new TrafficLightCtrl();
        if(color.toString().equals(tlc.getGreenState().getColor())){
            TrafficLightGui.green.turnOn(true);
            TrafficLightGui.yellow.turnOn(false);
            TrafficLightGui.red.turnOn(false);
        }
        else if(color.equals(tlc.getYellowState().getColor())){
            TrafficLightGui.green.turnOn(false);
            TrafficLightGui.yellow.turnOn(true);
            TrafficLightGui.red.turnOn(false);
        }
        else if(color.equals(tlc.getRedState().getColor())){
            TrafficLightGui.green.turnOn(false);
            TrafficLightGui.yellow.turnOn(false);
            TrafficLightGui.red.turnOn(true);
        }
    }*/
}
