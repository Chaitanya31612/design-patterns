import java.util.Stack;
import commands.Command;

/**
 * The Invoker class representing a Smart Home Remote Control.
 * Each button slot triggers a command. Executed commands are stored
 * in an undo stack to support multi-level undo.
 */
public class RemoteControl {
    private final Command[] commands;
    private final Stack<Command> undoStack;

    public RemoteControl(int numSlots) {
        this.commands = new Command[numSlots];
        this.undoStack = new Stack<>();
    }

    public void setCommand(int slot, Command command) {
        if (slot < 0 || slot >= commands.length) {
            throw new IndexOutOfBoundsException("Invalid slot: " + slot);
        }
        commands[slot] = command;
    }

    public void pressButton(int slot) {
        if (slot < 0 || slot >= commands.length || commands[slot] == null) {
            throw new IllegalArgumentException("No command assigned to slot: " + slot);
        }
        commands[slot].execute();
        undoStack.push(commands[slot]);
    }

    public void undoLastAction() {
        if (!undoStack.isEmpty()) {
            Command lastCommand = undoStack.pop();
            lastCommand.undo();
        }
    }
}
