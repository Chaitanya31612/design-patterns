package commands;

/**
 * Command interface. Each command encapsulates an action
 * and provides execution and stateful undo capabilities.
 */
public interface Command {
    void execute();
    void undo();
}
