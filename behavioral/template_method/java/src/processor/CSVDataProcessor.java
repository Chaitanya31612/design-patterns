package processor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class CSVDataProcessor extends DataProcessor {

  @Override
  public void extractData() {
    try {
      this.rawData = Files.readString(Path.of(filePath));
      System.out.println("Extracted raw CSV content.");
    } catch (IOException e) {
      System.err.println("Error reading CSV file: " + e.getMessage());
    }
  }

  @Override
  public void processData() {
    if (rawData == null || rawData.isBlank()) return;

    System.out.println("\n--- Formatted CSV Table ---");
    String[] rows = rawData.split("\\r?\\n"); // split by newline

    System.out.println("+-------------------+-------------------+-------------------+");
    for (String row : rows) {
      String[] cols = row.split(","); // split by comma
      // Note: Formats the first 3 columns; rows with < 3 columns or extra columns beyond index 2 are ignored/skipped
      if (cols.length >= 3) {
        System.out.printf("| %-17s | %-17s | %-17s |%n", cols[0].trim(), cols[1].trim(), cols[2].trim());
      }
    }
    System.out.println("+-------------------+-------------------+-------------------+");
  }

  @Override
  protected boolean printSummary() {
    // hook is overridden to return false, so summary is not printed
    return false;
  }
}
