package umbcs680.AC;

public class DecreasingTempState implements State {


    public void turnOn(AirConditioner ac) {
        System.out.println("AC is already on");
    }

    public void turnOff(AirConditioner ac) {
        System.out.println("AC is turning off");
        ac.changeState(new OffState());

    }

    public void increaseTemp(AirConditioner ac) {
        System.out.println("Increasing Temperature");
        ac.changeState(new IncreasingTempState());
    }

    public void decreaseTemp(AirConditioner ac) {
        System.out.println("Decreasing Temperature");
    }

    public String toString() {
        return "DecreasingTempState";
    }
}
