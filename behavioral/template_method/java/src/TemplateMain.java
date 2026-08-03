import processor.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class TemplateMain {
    public static void main(String[] args) throws IOException {
        String csvFile = "sample_data.csv";
        String jsonFile = "sample_data.json";
        String txtFile = "sample_data.txt";

        // Create sample dummy files
        Files.writeString(Path.of(csvFile), "Name,Role,Department\nAlice,Developer,Engineering\nBob,Designer,Product");
        Files.writeString(Path.of(jsonFile), "{\"title\":\"Template Method\",\"author\":\"GoF\",\"year\":1994}");
        Files.writeString(Path.of(txtFile), "The Template Method pattern defines the skeleton of an algorithm in a base class.");

        // 1. Process CSV
        System.out.println("=== CSV Processing ===");
        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.process(csvFile);

        // 2. Process JSON
        System.out.println("=== JSON Processing ===");
        DataProcessor jsonProcessor = new JSONDataProcessor();
        jsonProcessor.process(jsonFile);

        // 3. Process Text
        System.out.println("=== Text Processing ===");
        DataProcessor txtProcessor = new TextDataProcessor();
        txtProcessor.process(txtFile);

        // Cleanup dummy files
        Files.deleteIfExists(Path.of(csvFile));
        Files.deleteIfExists(Path.of(jsonFile));
        Files.deleteIfExists(Path.of(txtFile));
    }
}
