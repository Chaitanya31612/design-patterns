package commands;

import java.util.Stack;
import appliances.Light;

public class LightOffCommand implements Command {
    private final Light light;
    private final Stack<Boolean> prevStates;

    public LightOffCommand(Light light) {
        this.light = light;
        this.prevStates = new Stack<>();
    }

    @Override
    public void execute() {
        prevStates.push(light.isOn());
        light.turnOff();
    }

    @Override
    public void undo() {
        if (!prevStates.isEmpty()) {
            boolean wasOn = prevStates.pop();
            if (wasOn) {
                light.turnOn();
            } else {
                light.turnOff();
            }
        }
    }
}
