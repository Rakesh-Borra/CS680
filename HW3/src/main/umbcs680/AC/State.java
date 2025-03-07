package umbcs680.AC;

public interface State {
    //Each state will have 4 buttons
    void turnOn(AirConditioner ac);
    void turnOff(AirConditioner ac);
    void increaseTemp(AirConditioner ac);
    void decreaseTemp(AirConditioner ac);
}