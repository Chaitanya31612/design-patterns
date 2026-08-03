package devices;

public class SoundSystem {
    public void on() {
        System.out.println("Sound system is on");
    }

    public void off() {
        System.out.println("Sound system is off");
    }

    public void setVolume(int level) {
        System.out.println("Sound system volume set to " + level);
    }

    public void setMode(String mode) {
        System.out.println("Sound system mode set to " + mode + " Sound");
    }
}
