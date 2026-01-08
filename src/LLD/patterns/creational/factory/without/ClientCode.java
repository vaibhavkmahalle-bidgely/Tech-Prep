package LLD.patterns.creational.factory.without;

public class ClientCode {
    public void notifyUser(String msg, String type) {
        if (type.equals("Email")) {
            EmailNotification email = new EmailNotification();
            email.send(msg);
        } else if (type.equals("SMS")) {
            SMSNotification sms = new SMSNotification();
            sms.send(msg);
        } else {
            System.out.println("Invalid notification type.");
        }
    }

    public static void main(String[] args) {
        ClientCode clientObj = new ClientCode();

        clientObj.notifyUser("ye le sms", "SMS");
        clientObj.notifyUser("ye le email", "Email");
    }
}
