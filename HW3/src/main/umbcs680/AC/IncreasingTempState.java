package umbcs680.AC;

public class IncreasingTempState implements State {

    public void turnOn(AirConditioner ac) {

        System.out.println("AC is already on");
    }

    public void turnOff(AirConditioner ac) {
        System.out.println("AC is Turning off");

        ac.changeState(new OffState());
    }

    public void increaseTemp(AirConditioner ac) {
        System.out.println("Temperature is already increasing");

    }

    public void decreaseTemp(AirConditioner ac) {
        System.out.println("Decreasing Temp ");
        ac.changeState(new DecreasingTempState());
    }

    public String toString() {
        return "IncreasingTempState";
    }
}
