package umbcs680.observer;

public class JointBankAccount extends CreditObservable {

    private double balance;
    private final DebitObservable debitObservable = new DebitObservable() ;

    public JointBankAccount(double balance) {

        this.balance = balance;
    }

    public void deposit(double amount) {

        balance += amount;
        notifyObservers(new CreditEvent(amount));
    }

    public void withdraw(double amount) {

        if (amount <= balance) {

            balance -= amount;
            debitObservable.notifyObservers(new DebitEvent(amount));
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void addDebitObserver(DebitObserver observer) {
        debitObservable.addObserver(observer);
    }

}