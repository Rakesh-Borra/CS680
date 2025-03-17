package umbcs680.observer;
import java.util.ArrayList;
import java.util.List;

public class FamilyMember implements CreditObserver, DebitObserver {

    private final String name;
    private final List<String> creditNotifications = new ArrayList<>();
    private final List<String> debitNotifications = new ArrayList<>();

    public FamilyMember(String name) {
        this.name = name;
    }

    @Override
    public void updateCredit(CreditEvent event) {
        String message = name + " received credit notification: Bank account credited with $" + event.getAmount();
        creditNotifications.add(message);
        System.out.println(message);
    }

    @Override
    public void updateDebit(DebitEvent event) {
        String message = name + " received debit notification: Bank account debited with $" + event.getAmount();
        debitNotifications.add(message);
        System.out.println(message);
    }

    public List<String> getCreditNotifications() {
        return creditNotifications;
    }

    public List<String> getDebitNotifications() {
        return debitNotifications;
    }
}
