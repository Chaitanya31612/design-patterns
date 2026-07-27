package creater;

import product.*;

public class EmailNotificationSender extends NotificationSender {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
