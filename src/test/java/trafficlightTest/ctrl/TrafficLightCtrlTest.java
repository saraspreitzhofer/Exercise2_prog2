package trafficlightTest.ctrl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import trafficlight.ctrl.TrafficLightCtrl;

public class TrafficLightCtrlTest {

    @Test
    @DisplayName("Only one instance created")
    public void getInstanceTest(){
        TrafficLightCtrl instance1 = TrafficLightCtrl.getInstance();
        TrafficLightCtrl instance2 = TrafficLightCtrl.getInstance();
        assertEquals(instance1, instance2);
    }

    @Test
    @DisplayName("Correct getNextState green to yellow")
    public void getNextStateTest1(){
        TrafficLightCtrl instance = TrafficLightCtrl.getInstance();
        assertEquals(instance.getGreenState().getNextState(), instance.getYellowState());
    }
    @Test
    @DisplayName("Correct getNextState yellow to red")
    public void getNextStateTest2(){
        TrafficLightCtrl instance = TrafficLightCtrl.getInstance();
        assertEquals(instance.getYellowState().getNextState(), instance.getRedState());
    }
    @Test
    @DisplayName("Correct getNextState for yellow to green")
    public void getNextStateTest3(){
        TrafficLightCtrl instance = TrafficLightCtrl.getInstance();
        instance.nextState();       //green to yellow
        instance.nextState();       //yellow to red
        assertEquals(instance.getYellowState().getNextState(), instance.getGreenState());
    }
    @Test
    @DisplayName("Correct getNextState red to yellow")
    public void getNextStateTest4(){
        TrafficLightCtrl instance = TrafficLightCtrl.getInstance();
        assertEquals(instance.getRedState().getNextState(), instance.getYellowState());
    }

}