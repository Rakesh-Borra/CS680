package umbcs680.observer;

public class DebitEvent {
    private final double amount;

    public DebitEvent(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }


}
