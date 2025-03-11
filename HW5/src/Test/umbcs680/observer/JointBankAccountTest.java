package umbcs680.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JointBankAccountTest {

    JointBankAccount bofa = new JointBankAccount("bofa",5000.0);
    JointBankAccount chase = new JointBankAccount("chase",3000.0);
    JointBankAccount capitalOne = new JointBankAccount("capitalOne",1500.0);

    FamilyMember rakesh = new FamilyMember("rakesh");
    FamilyMember dinesh = new FamilyMember("dinesh");
    FamilyMember david = new FamilyMember("david");
    FamilyMember jack = new FamilyMember("jack");
    FamilyMember mark = new FamilyMember("mark");


    // Testing whether every observers receiving notifications from every bank or not;
    @Test
    public void TestingNotifyObservers() {
        bofa.addObserver(rakesh);
        bofa.addObserver(dinesh);
        bofa.addObserver(david);

        chase.addObserver(rakesh);
        chase.addObserver(mark);

        capitalOne.addObserver(jack);
        capitalOne.addObserver(mark);

        bofa.DebitMoney(100.0);
        chase.CreditMoney(500.0);
        capitalOne.DebitMoney(150.0);
        String expectedMessage1 = "bofa: 100.0 Dollars Debited from account. New balance: 4900.0";
        String expectedMessage2 = "chase: 500.0 Dollars Credited into account. New Balance: 3500.0";
        String expectedMessage3 = "capitalOne: 150.0 Dollars Debited from account. New balance: 1350.0";


        assertEquals(expectedMessage1 ,dinesh.getLastMessage());
        assertEquals(expectedMessage1, david.getLastMessage());
        assertEquals(expectedMessage2, rakesh.getLastMessage());
        assertEquals(expectedMessage3, mark.getLastMessage());
        assertEquals(expectedMessage3, jack.getLastMessage());

    }

    @Test
    public void TestingCountObservers() {

        bofa.addObserver(rakesh);
        bofa.addObserver(david);
        bofa.addObserver(jack);

        chase.addObserver(rakesh);
        chase.addObserver(dinesh);
        chase.addObserver(david);
        chase.addObserver(mark);

        capitalOne.addObserver(dinesh);
        capitalOne.addObserver(jack);
        capitalOne.addObserver(mark);

        assertEquals(3, bofa.countObservers());
        assertEquals(4, chase.countObservers());
        assertEquals(3, capitalOne.countObservers());
    }

    @Test
    void TestingClearObservers() {

        bofa.addObserver(rakesh);
        bofa.addObserver(david);

        chase.addObserver(rakesh);
        chase.addObserver(dinesh);

        bofa.clearObservers();
        chase.clearObservers();

        assertTrue(bofa.getObservers().isEmpty());
        assertTrue(chase.getObservers().isEmpty());

    }

    @Test
    void testingAddObserver() {
        assertTrue(bofa.getObservers().isEmpty());
        bofa.addObserver(rakesh);
        bofa.addObserver(dinesh);
        int expected = 2;
        assertEquals(expected, bofa.countObservers());
    }

    @Test //Testing by comparing the sizes;
    public void TestingRemoveObserver() {
        bofa.addObserver(rakesh);
        bofa.addObserver(mark);
        assertEquals(2, bofa.countObservers());
        bofa.removeObserver(rakesh);
        assertEquals(1, bofa.getObservers().size());
    }



}