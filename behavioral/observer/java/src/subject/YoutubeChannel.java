package subject;

import java.util.*;
import observer.Observer;

public class YoutubeChannel implements Subject {
    private List<Observer> observers;
    private String name;
    private String latestVideo;

    public YoutubeChannel(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void uploadVideo(String newVideo) {
        System.out.println("Uploading video: " + newVideo);
        latestVideo = newVideo;
        notifyObservers();
    }

    public String getLatestVideo() {
        return latestVideo;
    }
}
