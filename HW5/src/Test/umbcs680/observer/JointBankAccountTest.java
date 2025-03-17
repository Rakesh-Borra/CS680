package umbcs680.observer;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class JointBankAccountTest {

    private JointBankAccount account;
    private FamilyMember rakesh;
    private FamilyMember adeeb;
    private FamilyMember chandu;
    private FamilyMember hari;

    @BeforeEach
    public void setUp() {
        account = new JointBankAccount(1000.0);
        rakesh = new FamilyMember("Rakesh");
        adeeb = new FamilyMember("Adeeb");
        chandu = new FamilyMember("Chandu");
        hari = new FamilyMember("Hari");

        account.addObserver(rakesh);
        account.addObserver(adeeb);
        account.addObserver(chandu);
        account.addObserver(hari);

        account.addDebitObserver(rakesh);
        account.addDebitObserver(adeeb);
        account.addDebitObserver(chandu);
        account.addDebitObserver(hari);
    }

    @Test
    public void testDeposit() {
        account.deposit(500.0);

        // Verify that each family member received the credit notification
        assertTrue(rakesh.getCreditNotifications().contains("Rakesh received credit notification: Bank account credited with $500.0"));
        assertTrue(adeeb.getCreditNotifications().contains("Adeeb received credit notification: Bank account credited with $500.0"));
        assertTrue(chandu.getCreditNotifications().contains("Chandu received credit notification: Bank account credited with $500.0"));
        assertTrue(hari.getCreditNotifications().contains("Hari received credit notification: Bank account credited with $500.0"));
    }

    @Test
    public void testWithdraw() {
        account.withdraw(200.0);

        // Verify that each family member received the debit notification
        assertTrue(rakesh.getDebitNotifications().contains("Rakesh received debit notification: Bank account debited with $200.0"));
        assertTrue(adeeb.getDebitNotifications().contains("Adeeb received debit notification: Bank account debited with $200.0"));
        assertTrue(chandu.getDebitNotifications().contains("Chandu received debit notification: Bank account debited with $200.0"));
        assertTrue(hari.getDebitNotifications().contains("Hari received debit notification: Bank account debited with $200.0"));
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        account.withdraw(2000.0);

        // Verify that no debit notifications were sent due to insufficient funds
        assertTrue(rakesh.getDebitNotifications().isEmpty());
        assertTrue(adeeb.getDebitNotifications().isEmpty());
        assertTrue(chandu.getDebitNotifications().isEmpty());
        assertTrue(hari.getDebitNotifications().isEmpty());
    }

    @Test
    public void testRemoveObserver() {
        account.removeObserver(adeeb);
        account.deposit(300.0);

        // Verify that Adeeb did not receive the notification after being removed
        assertFalse(adeeb.getCreditNotifications().contains("Adeeb received credit notification: Bank account credited with $300.0"));

        // Verify that other family members received the notification
        assertTrue(rakesh.getCreditNotifications().contains("Rakesh received credit notification: Bank account credited with $300.0"));
        assertTrue(chandu.getCreditNotifications().contains("Chandu received credit notification: Bank account credited with $300.0"));
        assertTrue(hari.getCreditNotifications().contains("Hari received credit notification: Bank account credited with $300.0"));
    }
}

