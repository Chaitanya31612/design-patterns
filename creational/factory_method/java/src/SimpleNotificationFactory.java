import creater.*;

public class SimpleNotificationFactory {
    public static NotificationSender createNotificationSender(String type) {
        switch (type) {
            case "SMS":
                return new SMSNotificationSender();
            case "Email":
                return new EmailNotificationSender();
            case "WhatsApp":
                return new WhatsAppNotificationSender();
            default:
                throw new IllegalArgumentException("Unknown notification type (String): " + type);
        }
    }

    public static NotificationSender createNotificationSender(int choice) {
        switch (choice) {
            case 1:
                return new SMSNotificationSender();
            case 2:
                return new EmailNotificationSender();
            case 3:
                return new WhatsAppNotificationSender();
            default:
                throw new IllegalArgumentException("Unknown notification type (int): " + choice);
        }
    }
}
