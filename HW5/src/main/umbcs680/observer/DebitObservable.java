package umbcs680.observer;

import java.util.ArrayList;
import java.util.List;

public class DebitObservable {
    private final List<DebitObserver> observers = new ArrayList<>();

    public void addObserver(DebitObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(DebitObserver observer) {
        observers.remove (observer);
    }

    public void notifyObservers(DebitEvent event) {

        for (DebitObserver observer : observers) {
            observer.updateDebit(event) ;
        }

    }


}