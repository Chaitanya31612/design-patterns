package appliances;

public class Fan {
    private boolean isOn = false;

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        this.isOn = true;
        System.out.println("Fan is on");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("Fan is off");
    }
}
