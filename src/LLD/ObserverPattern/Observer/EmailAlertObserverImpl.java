package LLD.ObserverPattern.Observer;

import LLD.ObserverPattern.Observable.StockObservable;

public class EmailAlertObserverImpl implements  NotificationAlertObserver{

    String emailId;
    StockObservable observable;

    public EmailAlertObserverImpl(String emailId, StockObservable observable){
        this.emailId = emailId;
        this.observable = observable;

    }
    @Override
    public void update() {
        sendMail(emailId, "product is in Stock, hurry up.");
    }

    public void sendMail(String emailId, String msg){
        System.out.println("Mail sent to :"+ emailId);
        // send actual email to end user
    }
}
