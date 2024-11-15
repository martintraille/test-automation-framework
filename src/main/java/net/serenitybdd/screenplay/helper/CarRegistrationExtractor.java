package net.serenitybdd.screenplay.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarRegistrationExtractor {
    public static List<String> extractRegistrations(String filePath) throws IOException {
        List<String> registrations = new ArrayList<>();

        // Reg patten to check for car regs with and without spaces - | is a logical OR
        Pattern pattern = Pattern.compile("\\b[A-Z]{2}\\d{2} [A-Z]{3}\\b|\\b[A-Z]{2}\\d{2}[A-Z]{3}\\b");

        // Process each line from the file
        for (String line : Files.readAllLines(Path.of(filePath))) {

            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String matchedRegistration = matcher.group();
                System.out.println("Matched Registration: " + matchedRegistration); // Debugging line to make sure the matches are correctly outputted
                registrations.add(matchedRegistration);
            }
        }

     return registrations;

    }

}
