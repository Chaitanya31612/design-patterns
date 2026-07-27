import java.util.Scanner;

import creater.*;

public class FactoryMain {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the message");
      String message = sc.nextLine();

      System.out.println("Enter where to send notification: \n 1) SMS \n 2) Email \n 3) WhatsApp \n Enter your choice (1/2/3) or (SMS/Email/WhatsApp): ");

      NotificationSender notificationSender;
      if (sc.hasNextInt()) {
          int intChoice = sc.nextInt(); // Reads it directly as an int
          notificationSender = SimpleNotificationFactory.createNotificationSender(intChoice);
      } else {
          String strChoice = sc.next(); // Reads it as a String
          notificationSender = SimpleNotificationFactory.createNotificationSender(strChoice);
      }

      notificationSender.sendAlert(message);

    }
}
