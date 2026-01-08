package LLD.patterns.creational.factory.with;

public class EmailNotification implements Notification{
    @Override
    public void send(String msg) {
        System.out.println(msg);
    }
}
