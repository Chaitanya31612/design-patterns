package commands;

import java.util.Stack;
import appliances.Fan;

public class FanOffCommand implements Command {
    private final Fan fan;
    private final Stack<Boolean> prevStates;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
        this.prevStates = new Stack<>();
    }

    @Override
    public void execute() {
        prevStates.push(fan.isOn());
        fan.turnOff();
    }

    @Override
    public void undo() {
        if (!prevStates.isEmpty()) {
            boolean wasOn = prevStates.pop();
            if (wasOn) {
                fan.turnOn();
            } else {
                fan.turnOff();
            }
        }
    }
}
