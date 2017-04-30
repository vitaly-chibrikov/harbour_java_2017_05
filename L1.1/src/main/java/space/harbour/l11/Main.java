package space.harbour.l11;

import au.com.bytecode.opencsv.CSVReader;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tully.
 *
 * to run in the terminal:
 * java -classpath "./target/L1.1.jar" space.harbour.l11.Main
 * java -classpath "./target/L1.1.jar:/home/tully/.m2/repository/net/sf/opencsv/opencsv/2.3/opencsv-2.3.jar" space.harbour.l11.Main
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String pathToFile = "emails.csv";

        System.out.println("Reading emails from: " + pathToFile);

        CSVReader reader = new CSVReader(new FileReader(pathToFile));
        List<String[]> lines = reader.readAll();

        for (String[] line : lines) {
            String email = line[0].trim();
            int unread = Integer.valueOf(line[1].trim());
            boolean isProtected = Boolean.valueOf(line[2].trim());

            System.out.println("Email: " + email + " unread: " + unread + " protected: " + isProtected);
        }
    }
}
