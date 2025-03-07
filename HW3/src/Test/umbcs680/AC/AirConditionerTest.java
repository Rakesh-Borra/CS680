package umbcs680.AC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AirConditionerTest {

    @Test
    //checking Singleton Instances;
    public void checkACSingleton(){
        AirConditioner ac1=AirConditioner.getInstance();
        AirConditioner ac2=AirConditioner.getInstance();
        assertSame(ac1,ac2);
    }

    @Test

    public void checkTurnOnButton(){
        AirConditioner ac = AirConditioner.getInstance(); // OffState
        ac.turnOn();
        assertEquals("OnState", ac.getCurrentState().toString());
    }

    @Test
    public void checkTurnOffButton() {
        AirConditioner ac = AirConditioner.getInstance();
        ac.turnOn();
        ac.turnOff();
        assertEquals("OffState", ac.getCurrentState().toString());
    }

    @Test
    public void checkIncreasingTempButton(){
        AirConditioner ac = AirConditioner.getInstance();
        ac.turnOn();// new OnState
        ac.increaseTemp();
        assertEquals("IncreasingTempState", ac.getCurrentState().toString());

    }

    @Test
    public void checkDecreasingTempButton(){
        AirConditioner ac = AirConditioner.getInstance();
        ac.turnOn();// new OnState
        ac.decreaseTemp();
        assertEquals("DecreasingTempState",ac.getCurrentState().toString());
    }
}