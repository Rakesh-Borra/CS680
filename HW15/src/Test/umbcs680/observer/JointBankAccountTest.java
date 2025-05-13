package umbcs680.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;


public class JointBankAccountTest{
	

    @Test
    void testingAddObserver(){

        JointBankAccount jointAccount = new JointBankAccount(1000.00);
        assertTrue(jointAccount.getObservers().isEmpty());
        jointAccount.addObserver((sender, event)->System.out.println("Rakesh is notified: "+event));
        
        int expected=1;

        //test by comparing the size of the observer list
        assertEquals(expected, jointAccount.getObservers().size());
    }

    @Test
    public void TestingRemoveObserver(){

        JointBankAccount jointAccount = new JointBankAccount(1000.00);
        Observer<String> Rakesh=(sender, event)->System.out.println("Rakesh is notified: "+event);
        Observer<String> Dinesh =(sender, event)->System.out.println("Dinesh is notified: "+ event);	
        jointAccount.addObserver(Rakesh);
        jointAccount.addObserver(Dinesh);

        // Testing whether both the observers are in the list or not;
        assertEquals(2, jointAccount.getObservers().size());

        // Testing size of the list after removal
        jointAccount.removeObserver(Rakesh);
        assertEquals(1, jointAccount.getObservers().size());

    }


//     Testing whether every observers receiving notifications or not;
    @Test
    public void TestingNotifyObservers(){

        JointBankAccount jointAccount=new JointBankAccount(1000.00);
        final String[] rakeshMessage=new String[1];
        final String[] dineshMessage=new String[1];
        final String[] davidMessage=new String[1];
        
        jointAccount.addObserver((sender, event)->{
            rakeshMessage[0]=event;
            System.out.println("rakesh is notified: "+event);
        });

        jointAccount.addObserver((sender, event)->{
            dineshMessage[0]=event;
            System.out.println("dinesh is notified: "+event);
        });

        jointAccount.addObserver((sender, event)->{
            davidMessage[0]=event;
            System.out.println("david is notified: "+event);
        });

        String expectedMessage = "100.0 Dollars Debited from account. New balance: 900.0";
        jointAccount.DebitMoney(100.00);

        assertEquals(expectedMessage, rakeshMessage[0]);
        assertEquals(expectedMessage , dineshMessage[0]);
        assertEquals(expectedMessage, davidMessage[0]);

    }


    @Test
    public void AmountDebitedOrNot(){

        JointBankAccount jointAccount = new JointBankAccount(1000.00);
        FamilyMember Rakesh = new FamilyMember("Rakesh");
        final String[] rakeshMessage = new String[1];
        
        jointAccount.addObserver((sender, event)->{
            rakeshMessage[0] = event;
            System.out.println( "Rakesh is notified: "+event);
        });

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
    public void AmountCreditedOrNot(){

    	final String[] rakeshMessage = new String[1];
        JointBankAccount jointAccount = new JointBankAccount(1000.00);

        jointAccount.addObserver((sender, event)->{
            rakeshMessage[0]=event;
            System.out.println("rakesh is notified: "+event);
        });

        double  initialBalance= jointAccount.getBalance();
        double creditAmount = 500.00;
        jointAccount.CreditMoney(creditAmount);
        double Expected= initialBalance+creditAmount;

        assertEquals(Expected, jointAccount.getBalance());
    }



}