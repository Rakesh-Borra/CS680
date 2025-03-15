package umbcs680.AC;

public class AirConditioner {
    private static AirConditioner instance;
    private State currentState;
    private int temperature;

    private AirConditioner() {
        this.currentState = new OffState();
        this.temperature= 24; // considering 24 as a normal room temp;
    }

    public static AirConditioner getInstance(){
        if(instance==null){
            instance=new AirConditioner();
        }return instance;
    }

    public void changeState(State state) {
        this.currentState = state;
    }

    public void turnOn() {
        currentState.turnOn(this);
    }

    public void turnOff() {
        currentState.turnOff(this);
    }

    public void increaseTemp() {
        currentState.increaseTemp(this);
        temperature +=1;
    }

    public void decreaseTemp() {
        currentState.decreaseTemp(this);
        temperature-=1;
    }
    public State getCurrentState() {
        return currentState;
    }

    public int getTemperature(){
        return temperature;
    }
}
