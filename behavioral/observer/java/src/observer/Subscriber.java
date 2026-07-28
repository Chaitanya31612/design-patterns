package observer;

import subject.Subject;

public class Subscriber implements Observer {
    private String name;
    private Subject subject;

    public Subscriber(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received new notification for video: " + message);
    }
}
