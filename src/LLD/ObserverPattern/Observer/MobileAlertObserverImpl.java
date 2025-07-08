package LLD.ObserverPattern.Observer;

import LLD.ObserverPattern.Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{

    String mobilNo;
    StockObservable observable;

    public MobileAlertObserverImpl(String mobilNo, StockObservable observable){
        this.mobilNo = mobilNo;
        this.observable = observable;
    }
    @Override
    public void update() {
        sendSms(mobilNo, "Product is in stock");
    }

    public void sendSms(String mobilNo, String msg){
        System.out.println("Sms sent to "+ mobilNo);
        // send sms to actual user;
    }
}
