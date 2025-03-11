package umbcs680.observer;

import java.util.ArrayList;
import java.util.List;

public class JointBankAccount extends Observable<String> {

    private double balance;
    private final String bankName;

    public JointBankAccount(String bankName, double initialBalance) {
         this.balance = initialBalance ;
         this.bankName= bankName;
    }

    public double getBalance() {
        return balance;
    }
    public String toString() {
        return bankName;
    }

        //To debit amount and get message;
    public void DebitMoney(double amount) {

        if (amount<= balance) {

             balance-= amount;
            notifyObservers(bankName +": "+ amount + " Dollars Debited from account. New balance: " + balance);
        } else {
            System.out.println(bankName +": Insufficient funds to withdraw "+ amount+" Dollars");
        }
    }

    // To credit amount and get message;
    public void CreditMoney(double amount) {

        balance+=  amount;
        notifyObservers(bankName +": " +amount  + " Dollars Credited into account. New Balance: " + balance);
    }

}



