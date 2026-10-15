package lab10;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileReadingDemo {

    public static void main(String[] args) {

        String fileName = "student_details.txt";

        System.out.println("Reading Student Details:");
        System.out.println();

        // Try-with-resources closes the reader automatically
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

            System.out.println();
            System.out.println("File read successfully!");

        } catch (IOException e) {

            System.out.println("Error reading file: "
                    + e.getMessage());
        }
    }
}
