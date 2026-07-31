import java.util.Stack;

import commands.Command;

public class RemoteControl {
    private Command[] commands;
    private Stack<Command> undoStack;

    public RemoteControl(int numSlots) {
        this.commands = new Command[numSlots];
        this.undoStack = new Stack<>();
    }

    public void setCommand(int slot, Command command) {
        commands[slot] = command;
    }

    public void pressButton(int slot) {
      if (commands[slot] == null) {
        throw new IllegalArgumentException("Command not set for slot: " + slot);
      }

      commands[slot].toggle();
      undoStack.push(commands[slot]);
    }

    public void undoLastAction() {
      if (undoStack.isEmpty()) {
        return;
      }
      undoStack.pop().toggle();
    }
}
