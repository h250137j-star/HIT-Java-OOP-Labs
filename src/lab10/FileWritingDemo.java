package lab10;

import java.io.FileWriter;
import java.io.IOException;

public class FileWritingDemo {

    public static void main(String[] args) {

        String fileName = "student_details.txt";

        // Try-with-resources automatically closes the file
        try (FileWriter writer = new FileWriter(fileName)) {

            // Write student information to the file
            writer.write("STUDENT DETAILS\n");
            writer.write("--------------------------\n");
            writer.write("Name: Precious Millicent Zvidi\n");
            writer.write("Registration Number: H250137J\n");
            writer.write("Department: Software Engineering\n");
            writer.write("Institution: Harare Institute of Technology\n");

            System.out.println("File created successfully!");
            System.out.println("Student details written to "
                    + fileName);

        } catch (IOException e) {

            System.out.println("Error writing to file: "
                    + e.getMessage());
        }
    }
}
