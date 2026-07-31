package commands;

import appliances.Fan;

public class FanCommand implements Command {
    private Fan fan;
    private boolean isOn;

    public FanCommand(Fan fan) {
        this.fan = fan;
        this.isOn = false;
    }

    @Override
    public void execute() {
        fan.turnOn();
        isOn = true;
    }

    @Override
    public void undo() {
        fan.turnOff();
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
