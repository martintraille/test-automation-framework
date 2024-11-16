package net.serenitybdd.screenplay.helper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileWriterUtils {
    public static void writeToFile(String filePath, Map<String, String> data, List<String> registration) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append("VARIANT_REG,MAKE,MODEL,YEAR\n"); // Write header

            writer.append((CharSequence) registration).append(",");
            writer.append(data.get("Manufacturer")).append(",");
            writer.append(data.get("Model")).append(",");
            writer.append(data.get("Year")).append("\n");
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }
}
