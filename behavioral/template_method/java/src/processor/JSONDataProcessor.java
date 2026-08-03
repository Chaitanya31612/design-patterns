package processor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class JSONDataProcessor extends DataProcessor {

  @Override
  public void extractData() {
    try {
      this.rawData = Files.readString(Path.of(filePath));
      System.out.println("Extracted raw JSON content.");
    } catch (IOException e) {
      System.err.println("Error reading JSON file: " + e.getMessage());
    }
  }

  @Override
  public void processData() {
    if (rawData == null || rawData.isBlank()) return;

    System.out.println("\n--- Formatted JSON ---");
    String prettyJson = rawData.replace("{", "{\n  ")
                               .replace("}", "\n}")
                               .replace(",", ",\n  ");
    System.out.println(prettyJson);
  }
}
