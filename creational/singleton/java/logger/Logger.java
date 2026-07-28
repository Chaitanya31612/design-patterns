package design_patterns.creational.singleton.java.logger;

import design_patterns.creational.singleton.java.FileHelper;

public enum Logger {
  CONSOLE_LOGGER {
    @Override
    public void log(String message) {
      System.out.println("Enum Logger: " + message);
    }
  },
  FILE_LOGGER {
    @Override
    public void log(String message) {
      FileHelper.writeToFile("Enum Logger: " + message);
    }
  };

  public abstract void log(String message);
}
