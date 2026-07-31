package commands;

import java.util.Stack;
import appliances.AC;

/**
 * Command to increase AC temperature.
 * Stores previous state before executing to support clean undo.
 */
public class AcTempUpCommand implements Command {
    private final AC ac;
    private final Stack<Integer> prevTemps;

    public AcTempUpCommand(AC ac) {
        this.ac = ac;
        this.prevTemps = new Stack<>();
    }

    @Override
    public void execute() {
        // Save state before executing
        prevTemps.push(ac.getTemperature());
        ac.setTemperature(ac.getTemperature() + 1);
    }

    @Override
    public void undo() {
        if (!prevTemps.isEmpty()) {
            int previousTemp = prevTemps.pop();
            ac.setTemperature(previousTemp);
        }
    }
}
