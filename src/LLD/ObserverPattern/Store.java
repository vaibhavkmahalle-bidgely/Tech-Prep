package LLD.ObserverPattern;

import LLD.ObserverPattern.Observable.IphoneObservableImpl;
import LLD.ObserverPattern.Observable.StockObservable;
import LLD.ObserverPattern.Observer.EmailAlertObserverImpl;
import LLD.ObserverPattern.Observer.MobileAlertObserverImpl;
import LLD.ObserverPattern.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StockObservable iphoneStockObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("vaibhavmahalle95@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer2 = new MobileAlertObserverImpl("8379930292", iphoneStockObservable);
        NotificationAlertObserver observer3 = new EmailAlertObserverImpl("vakdls", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);
        iphoneStockObservable.setStockCount(0);
        iphoneStockObservable.setStockCount(10);


    }
}
