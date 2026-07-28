package design_patterns.creational.singleton.java;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileHelper {
  private static final Object fileLock = new Object();
  public static void writeToFile(String message) {
    try {
      synchronized (fileLock) {
        Path path = Path.of("design_patterns/creational/singleton/java/logs/logs.txt");
        Files.writeString(path, message + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        System.out.println("Message written to file: " + message);
        String content = Files.readString(path);
        System.out.println("--- File content --- \n" + content);
      }
    } catch (Exception e) {
      System.err.println("Error writing to file: " + e.getMessage());
    }
  }
}
