import appliances.*;
import commands.*;

public class CommandMain {
  public static void main(String[] args) {
    Light light = new Light();
    Fan fan = new Fan();
    AC ac = new AC();

    Command lightOn = new LightOnCommand(light);
    Command lightOff = new LightOffCommand(light);
    Command fanOn = new FanOnCommand(fan);
    Command acTempUp = new AcTempUpCommand(ac);
    Command acTempDown = new AcTempDownCommand(ac);

    RemoteControl remote = new RemoteControl(5);
    remote.setCommand(0, lightOn);
    remote.setCommand(1, lightOff);
    remote.setCommand(2, fanOn);
    remote.setCommand(3, acTempUp);
    remote.setCommand(4, acTempDown);

    System.out.println("--- Executing Commands ---");
    remote.pressButton(0); // Light is on
    remote.pressButton(3); // AC temp -> 23°C
    remote.pressButton(3); // AC temp -> 24°C
    remote.pressButton(4); // AC temp -> 23°C

    System.out.println("\n--- Executing Multi-Level Undo ---");
    remote.undoLastAction(); // Undo temp down -> AC temp back to 24°C
    remote.undoLastAction(); // Undo temp up   -> AC temp back to 23°C
    remote.undoLastAction(); // Undo temp up   -> AC temp back to 22°C
    remote.undoLastAction(); // Undo light on  -> Light is off
  }
}
