package commands;

import appliances.Light;

public class LightCommand implements Command {
    private Light light;
    private boolean isOn;

    public LightCommand(Light light) {
        this.light = light;
        this.isOn = false;
    }

    @Override
    public void execute() {
        light.turnOn();
        isOn = true;
    }

    @Override
    public void undo() {
        light.turnOff();
        isOn = false;
    }

    @Override
    public void toggle() {
        if (isOn) {
            undo();
        } else {
            execute();
        }
    }
}
