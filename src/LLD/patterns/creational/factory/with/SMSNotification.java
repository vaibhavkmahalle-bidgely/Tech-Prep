package LLD.patterns.creational.factory.with;

public class SMSNotification implements Notification{

    @Override
    public void send(String msg) {
        System.out.println(msg);
    }
}
