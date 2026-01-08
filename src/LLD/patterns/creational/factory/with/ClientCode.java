package LLD.patterns.creational.factory.with;

import javax.management.NotificationFilter;

public class ClientCode {

    public static void main(String[] args) {
       Notification smsNotification =  NotificationFactory.getNotification( "SMS");
       smsNotification.send("here is SMS");


        NotificationFactory.getNotification( "Email").send("here is EMAIL");
        NotificationFactory.getNotification( "WhatsApp").send("here is WhatsApp");
    }
}
