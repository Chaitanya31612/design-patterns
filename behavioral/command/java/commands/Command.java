package commands;

public interface Command {
    void execute();
    void undo();
    void toggle();
}
