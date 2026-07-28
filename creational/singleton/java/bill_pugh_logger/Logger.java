package design_patterns.creational.singleton.java.bill_pugh_logger;

import design_patterns.creational.singleton.java.FileHelper;

public class Logger {
  private LoggerType type;

  private Logger(LoggerType type) {
    this.type = type;
  }

  private static class ConsoleLoggerHandler {
    private static final Logger logger = new Logger(LoggerType.CONSOLE);
  }

  private static class FileLoggerHandler {
    private static final Logger logger = new Logger(LoggerType.FILE);
  }

  public static Logger getConsoleLogger() {
    return ConsoleLoggerHandler.logger;
  }

  public static Logger getFileLogger() {
    return FileLoggerHandler.logger;
  }

  public void log(String message) {
    switch (type) {
      case CONSOLE:
        System.out.println("Bill Pugh Logger: " + message);
        break;
      case FILE:
        FileHelper.writeToFile("Bill Pugh Logger: " + message);
        break;
    }
  }
}

enum LoggerType {
  CONSOLE,
  FILE
}
