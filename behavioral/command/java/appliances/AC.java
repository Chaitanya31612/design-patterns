package appliances;

public class AC {
    private int temperature;

    public AC() {
        this.temperature = 22; // default 22°C
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("AC temperature set to " + this.temperature + "°C");
    }

    public void turnOn() {
        System.out.println("AC is on");
    }

    public void turnOff() {
        System.out.println("AC is off");
    }
}
