import observer.*;
import subject.*;

public class ObserverMain {
    public static void main(String[] args) {
      YoutubeChannel channel = new YoutubeChannel("Dr. Beast");

      Subscriber sub1 = new Subscriber("Chaitanya", channel);
      Subscriber sub2 = new Subscriber("Guptaji", channel);

      channel.uploadVideo("How to make friends and influence people");

      channel.removeObserver(sub2);

      channel.uploadVideo("How to live alone peacefully");

      // output:
      // Uploading video: How to make friends and influence people
      // Chaitanya received new notification for video: How to make friends and influence people
      // Guptaji received new notification for video: How to make friends and influence people
      // Uploading video: How to live alone peacefully
      // Chaitanya received new notification for video: How to live alone peacefully
    }
}
