package commands;

import java.util.Stack;
import appliances.Light;

public class LightOnCommand implements Command {
    private final Light light;
    private final Stack<Boolean> prevStates;

    public LightOnCommand(Light light) {
        this.light = light;
        this.prevStates = new Stack<>();
    }

    @Override
    public void execute() {
        prevStates.push(light.isOn());
        light.turnOn();
    }

    @Override
    public void undo() {
        if (!prevStates.isEmpty()) {
            boolean wasOn = prevStates.pop();
            if (!wasOn) {
                light.turnOff();
            } else {
                light.turnOn();
            }
        }
    }
}
