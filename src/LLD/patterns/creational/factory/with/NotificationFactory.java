package LLD.patterns.creational.factory.with;

public class NotificationFactory {
    public static Notification getNotification(String channel) {
        Notification notification = null;

        if (channel.equalsIgnoreCase("SMS")) {
            notification = new SMSNotification();
        } else if (channel.equalsIgnoreCase("Email")) {
            notification = new EmailNotification();
        } else if (channel.equalsIgnoreCase("WhatsApp")) {
            notification = new WhatsAppNotification();
        } else {
            throw new IllegalArgumentException("Unknown notification type");
        }

        return notification;
    }
}
