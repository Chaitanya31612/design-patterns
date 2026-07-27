package creater;

import product.*;

public class WhatsAppNotificationSender extends NotificationSender {
    @Override
    public Notification createNotification() {
        return new WhatsAppNotification();
    }
}
