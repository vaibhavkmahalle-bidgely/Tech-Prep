package LLD.ObserverPattern.Observable;

import LLD.ObserverPattern.Observer.NotificationAlertObserver;

public interface StockObservable {

    public void add(NotificationAlertObserver observer);

    public void remove(NotificationAlertObserver observer);

    public void notifySuscribers();

    public void setStockCount(int newStockAdded);

    public int getStockCount();



}
