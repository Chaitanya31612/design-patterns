package creater;

import product.*;

public class SMSNotificationSender extends NotificationSender {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
