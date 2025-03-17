package umbcs680.observer;

public class CreditEvent {

    private final double amount;
    public CreditEvent(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }


}