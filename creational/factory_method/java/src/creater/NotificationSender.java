package creater;

import product.Notification;

public abstract class NotificationSender {
    private Notification notification;

    public void sendAlert(String message) {
      this.notification = createNotification();

      System.out.println("Sending notification from the NotificationSender");
      notification.send(message);
      System.out.println("Notification sent from the NotificationSender");
    }

    public abstract Notification createNotification();
}
