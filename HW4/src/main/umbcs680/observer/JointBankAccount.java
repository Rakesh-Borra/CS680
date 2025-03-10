package umbcs680.observer;

import java.util.ArrayList;
import java.util.List;

public class JointBankAccount extends Observable<String> {

    private double balance;


    public JointBankAccount(double initialBalance) {
         this.balance = initialBalance ;
    }

    public double getBalance() {
        return balance;
    }

        //To debit amount and get message;
    public void DebitMoney(double amount) {

        if (amount<= balance) {

             balance-= amount;
            notifyObservers( amount + " Dollars Debited from account. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds to withdraw "+ amount+" Dollars");
        }
    }

    // To credit amount and get message;
    public void CreditMoney(double amount) {

        balance+=  amount;
        notifyObservers(amount  + " Dollars Credited into account. Balance: " + balance);
    }

}



