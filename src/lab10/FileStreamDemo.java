package lab10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileStreamDemo {

    public static void main(String[] args) {

        Path filePath = Path.of("student_marks.txt");

        // Student marks to be saved
        List<String> marks = List.of(
                "45", "78", "90", "62", "35", "88", "55"
        );

        try {

            // Write marks to a text file
            Files.write(filePath, marks);

            System.out.println("Student marks saved successfully.");

            // Read marks from the text file
            List<Integer> studentMarks = Files.readAllLines(filePath)
                    .stream()
                    .map(Integer::parseInt)
                    .toList();

            System.out.println("\nAll Student Marks:");
            System.out.println(studentMarks);

            // Filter passing marks
            List<Integer> passingMarks = studentMarks.stream()
                    .filter(mark -> mark >= 50)
                    .toList();

            System.out.println("\nPassing Marks:");
            System.out.println(passingMarks);

            // Count passing students
            long passCount = studentMarks.stream()
                    .filter(mark -> mark >= 50)
                    .count();

            System.out.println("\nNumber of Students Who Passed: "
                    + passCount);

            // Calculate average mark
            double average = studentMarks.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0);

            System.out.printf("Average Mark: %.2f%n", average);

            // Find highest mark
            int highest = studentMarks.stream()
                    .mapToInt(Integer::intValue)
                    .max()
                    .orElse(0);

            System.out.println("Highest Mark: " + highest);

            System.out.println("\nFile processing completed successfully.");

        } catch (IOException e) {

            System.out.println("File Error: " + e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println("Invalid mark found in file.");
        }
    }
}
