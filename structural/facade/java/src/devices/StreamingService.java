package devices;

public class StreamingService {
    public void on() {
        System.out.println("Streaming service is on");
    }

    public void off() {
        System.out.println("Streaming service is off");
    }

    public void play(String movie) {
        System.out.println("Streaming service playing " + movie);
    }
}
