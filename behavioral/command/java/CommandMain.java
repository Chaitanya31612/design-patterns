import appliances.*;
import commands.*;

public class CommandMain {
  public static void main(String[] args) {
    Light light = new Light();
    Fan fan = new Fan();

    Command lightCommand = new LightCommand(light);
    Command fanCommand = new FanCommand(fan);

    RemoteControl remote = new RemoteControl(5);
    remote.setCommand(0, lightCommand);
    remote.setCommand(1, fanCommand);

    // open and close the light
    remote.pressButton(0);
    remote.pressButton(0);

    // turn on and off the fan
    remote.pressButton(1);
    remote.pressButton(1);

    // only turn on the fan
    remote.pressButton(1);
    remote.undoLastAction();

  }
}
