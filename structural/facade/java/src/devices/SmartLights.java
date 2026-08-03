package devices;

public class SmartLights {
    public void on() {
        System.out.println("Smart lights are on");
    }

    public void off() {
        System.out.println("Smart lights are off");
    }

    public void dim(int percentage) {
        System.out.println("Smart lights are dimmed to " + percentage + "%");
    }
}
