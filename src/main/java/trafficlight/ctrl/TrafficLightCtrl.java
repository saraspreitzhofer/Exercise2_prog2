package trafficlight.ctrl;

import trafficlight.gui.TrafficLightGui;
import trafficlight.states.State;

public class TrafficLightCtrl {

    private State greenState;
    private State redState;
    private State yellowState;
    private State currentState;
    private State previousState;
    private final TrafficLightGui gui;
    private boolean doRun = true;

    private static TrafficLightCtrl instance = null;        //Singleton
    private TrafficLightCtrl(){
        super();
        initStates();
        gui = new TrafficLightGui(this);
        gui.setVisible(true);
        //TODO useful to update the current state
        currentState.notifyObservers();                     // turn on the light which should start
    }
    public static TrafficLightCtrl getInstance(){
        if(instance == null){
            instance = new TrafficLightCtrl();
        }
        return instance;
    }

    /*public TrafficLightCtrl() {                           //without Singleton
        super();
        initStates();
        gui = new TrafficLightGui(this);
        gui.setVisible(true);
        //TODO useful to update the current state
        currentState.notifyObservers();
    }*/

    private void initStates() {
        greenState = new State() {
            @Override
            public State getNextState() {
                previousState = currentState;
                //TODO useful to update the current state and the old one
                //implemented in nextState()
                //this.notifyObservers();           // turn off green light
                //yellowState.notifyObservers();    // turn on yellow light
                return yellowState;
            }
            @Override
            public String getColor() {
                return "green";
            }
        };

        redState = new State() {
            @Override
            public State getNextState() {
                previousState = currentState;
                //TODO useful to update the current state and the old one
                //implemented in nextState()
                //notifyObservers();                // turn off red light
                //yellowState.notifyObservers();    // turn on yellow light
                return yellowState;
            }
            @Override
            public String getColor() {
                return "red";
            }
        };

        yellowState = new State() {
            @Override
            public State getNextState() {
                if (previousState.equals(greenState)) {
                    previousState = currentState;
                    //TODO useful to update the current state and the old one
                    //implemented in nextState()
                    //this.notifyObservers();       // turn off yellow light
                    //redState.notifyObservers();   // turn on red light
                    return redState;
                }else {
                    previousState = currentState;
                    //TODO useful to update the current state and the old one
                    //implemented in nextState()
                    //this.notifyObservers();       // turn off yellow light
                    //currentState.notifyObservers();
                    //greenState.notifyObservers(); // turn on green light
                    return greenState;
                }
            }
            @Override
            public String getColor() {
                return "yellow";
            }
        };
        currentState = greenState;
        previousState = yellowState;
    }

    public State getGreenState() {
        return greenState;
    }

    public State getRedState() {
        return redState;
    }

    public State getYellowState() {
        return yellowState;
    }

    public void run()  {
        int intervall = 1500;
        while (doRun) {
            try {
                Thread.sleep(intervall);
                nextState();
            } catch (InterruptedException e) {
                gui.showErrorMessage(e);
            }
        }
        System.out.println("Stopped");
        System.exit(0);
    }

    public void nextState() {
        currentState = currentState.getNextState();

        currentState.notifyObservers();
        previousState.notifyObservers();
    }

    public void stop() {
        doRun = false;
    }

}