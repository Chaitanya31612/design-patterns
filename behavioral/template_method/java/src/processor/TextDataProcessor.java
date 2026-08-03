package processor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class TextDataProcessor extends DataProcessor {

  @Override
  public void extractData() {
    try {
      this.rawData = Files.readString(Path.of(filePath));
      System.out.println("Extracted raw Text content.");
    } catch (IOException e) {
      System.err.println("Error reading Text file: " + e.getMessage());
    }
  }

  @Override
  public void processData() {
    if (rawData == null || rawData.isBlank()) return;

    System.out.println("\n--- Formatted Text View ---");
    System.out.println("==================================================");
    System.out.println(rawData.trim());
    System.out.println("==================================================");
  }
}
