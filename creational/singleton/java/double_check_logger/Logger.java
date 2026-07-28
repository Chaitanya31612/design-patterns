package design_patterns.creational.singleton.java.double_check_logger;
import design_patterns.creational.singleton.java.FileHelper;

public class Logger {
  private static volatile Logger consoleLoggerInstance;
  private static volatile Logger fileLoggerInstance;

  LoggerType type;

  private Logger(LoggerType type) {
    this.type = type;
  }

  public static Logger getConsoleLogger() {
    if (consoleLoggerInstance == null) {
      synchronized (Logger.class) {
        if (consoleLoggerInstance == null) {
          consoleLoggerInstance = new Logger(LoggerType.CONSOLE);
        }
      }
    }
    return consoleLoggerInstance;
  }

  public static Logger getFileLogger() {
    if (fileLoggerInstance == null) {
      synchronized (Logger.class) {
        if (fileLoggerInstance == null) {
          fileLoggerInstance = new Logger(LoggerType.FILE);
        }
      }
    }
    return fileLoggerInstance;
  }

  public void log(String message) {
    switch (type) {
      case CONSOLE:
        System.out.println("DCL Logger: " + message);
        break;
      case FILE:
        FileHelper.writeToFile("DCL Logger: " + message);
        break;
    }
  }
}

enum LoggerType {
  CONSOLE,
  FILE
}
