package processor;

import java.nio.file.Files;
import java.nio.file.Path;

public abstract class DataProcessor {
  protected String filePath;
  protected String rawData;

  public DataProcessor() {}

  public void openFile(String filePath) {
    this.filePath = filePath;
    Path path = Path.of(filePath);
    if (!Files.exists(path)) {
      throw new IllegalArgumentException("File does not exist: " + filePath);
    }
    System.out.println("Opening file: " + filePath);
  }

  public abstract void extractData();
  public abstract void processData();

  public void closeFile() {
    System.out.println("Closing file: " + filePath);
    this.rawData = null;
  }

  // Hook method (optional)
  protected boolean printSummary() {
    return true;
  }

  // Template method defining the fixed sequence of steps
  public final void process(String filePath) {
    openFile(filePath);
    extractData();
    processData();
    closeFile();

    // hook
    if (printSummary()) {
      System.out.println("Processing is complete.");
    }
  }
}
