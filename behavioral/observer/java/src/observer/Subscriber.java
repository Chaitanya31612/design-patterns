package observer;

import subject.*;

public class Subscriber implements Observer {
    private String name;
    private Subject subject;

    public Subscriber(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof YoutubeChannel) {
            YoutubeChannel channel = (YoutubeChannel) subject;
            System.out.println(name + " received new notification for video: " + channel.getLatestVideo());
        } else {
            System.out.println(name + " received new notification from unknown subject");
        }
    }
}
