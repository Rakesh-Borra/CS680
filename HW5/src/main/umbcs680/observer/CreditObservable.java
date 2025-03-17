package umbcs680.observer;

import java.util.ArrayList;
import java.util.List;

public class CreditObservable {
    private final List<CreditObserver> observers = new ArrayList<>();

    public void addObserver(CreditObserver observer) {
         observers.add(observer);
    }


    public void removeObserver(CreditObserver observer) {
        observers.remove(observer);
    }


    public void notifyObservers(CreditEvent event) {

        for (CreditObserver observer : observers) {
             observer.updateCredit(event) ;
        }
    }


}
