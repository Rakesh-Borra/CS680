package umbcs680.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class JointBankAccountTest {

    @Test
    void testingAddObserver() {

        JointBankAccount jointAccount = new JointBankAccount(1000.00);
        FamilyMember Rakesh = new FamilyMember("Rakesh");

        assertTrue(jointAccount.getObservers().isEmpty());
        jointAccount.addObserver(Rakesh);
        int expected=1;

        //test by comparing the size of the observer list
        assertEquals(expected, jointAccount.getObservers().size());
    }

    @Test
    public void TestingRemoveObserver() {

        JointBankAccount jointAccount = new JointBankAccount(1000.00);
        FamilyMember Rakesh = new FamilyMember("Rakesh");
        FamilyMember Dinesh = new FamilyMember("Dinesh");

        jointAccount.addObserver(Rakesh);
        jointAccount.addObserver(Dinesh);

        // Testing whether both the observers are in the list or not;
        assertEquals(2, jointAccount.getObservers().size());

        // Testing size of the list after removal
        jointAccount.removeObserver(Rakesh);
        assertEquals(1, jointAccount.getObservers().size());
    }


    // Testing whether every observers receiving notifications or not;
    @Test
    public void TestingNotifyObservers() {

        JointBankAccount jointAccount = new JointBankAccount(1000.00);
        FamilyMember Rakesh = new FamilyMember("Rakesh");
        FamilyMember Dinesh = new FamilyMember("Dinesh");
        FamilyMember David = new FamilyMember("David");

        jointAccount.addObserver(Rakesh);
         jointAccount.addObserver(Dinesh);
        jointAccount.addObserver(David);

        String expectedMessage = "100.0 Dollars Debited from account. New balance: 900.0";
        jointAccount.DebitMoney(100.00);

        assertEquals(expectedMessage, Rakesh.getLastMessage());
        assertEquals(expectedMessage , Dinesh.getLastMessage());
        assertEquals(expectedMessage, David.getLastMessage());
    }


    @Test
    public void AmountDebitedOrNot() {

        JointBankAccount jointAccount = new JointBankAccount(1000.00);
        FamilyMember Rakesh = new FamilyMember("Rakesh");

        jointAccount.addObserver(Rakesh);

        double initialBalance = jointAccount.getBalance();
        double withdrawAmount = 500.00;

        jointAccount.DebitMoney(withdrawAmount);
        assertEquals(initialBalance - withdrawAmount, jointAccount.getBalance());

        // Trying to take extra Amount than balance;
        double extraAmount = 600.00;
        jointAccount.DebitMoney(extraAmount);
        assertEquals(initialBalance - withdrawAmount, jointAccount.getBalance());
    }


    @Test
    public void AmountCreditedOrNot() {

        JointBankAccount jointAccount = new JointBankAccount(1000.00);
        FamilyMember Rakesh = new FamilyMember("Rakesh");

        jointAccount.addObserver(Rakesh);

        double  initialBalance= jointAccount.getBalance();
        double creditAmount = 500.00;
        jointAccount.CreditMoney(creditAmount);
        double Expected= initialBalance + creditAmount;

        assertEquals(Expected, jointAccount.getBalance());
    }

}
