package commands;

import java.util.Stack;
import appliances.Fan;

public class FanOnCommand implements Command {
    private final Fan fan;
    private final Stack<Boolean> prevStates;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
        this.prevStates = new Stack<>();
    }

    @Override
    public void execute() {
        prevStates.push(fan.isOn());
        fan.turnOn();
    }

    @Override
    public void undo() {
        if (!prevStates.isEmpty()) {
            boolean wasOn = prevStates.pop();
            if (!wasOn) {
                fan.turnOff();
            } else {
                fan.turnOn();
            }
        }
    }
}
