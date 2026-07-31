package appliances;

public class Light {
    private boolean isOn = false;

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        this.isOn = true;
        System.out.println("Light is on");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("Light is off");
    }
}
