package umbcs680.AC;

public class OffState implements State {

    public void turnOn(AirConditioner ac) {
        System.out.println("Turning on the AC");
        ac.changeState(new OnState());

    }

    public void turnOff(AirConditioner ac) {

        System.out.println("AC is already off");
    }

    public void increaseTemp(AirConditioner ac) {

        System.out.println("Turn on AC to inc the temp");
    }

    public void decreaseTemp(AirConditioner ac) {

        System.out.println("Turn on AC to decrease the temp");
    }
}
