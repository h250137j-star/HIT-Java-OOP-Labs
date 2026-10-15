package lab10;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {

        // List of student marks
        List<Integer> marks = Arrays.asList(
                45, 78, 90, 62, 35, 88, 55
        );

        System.out.println("Original Student Marks:");
        System.out.println(marks);

        // Filter marks greater than or equal to 50
        System.out.println("\nPassing Marks:");

        marks.stream()
                .filter(mark -> mark >= 50)
                .forEach(System.out::println);

        // Sort marks in ascending order
        System.out.println("\nSorted Marks:");

        marks.stream()
                .sorted()
                .forEach(System.out::println);

        // Count students who passed
        long passedStudents = marks.stream()
                .filter(mark -> mark >= 50)
                .count();

        System.out.println("\nNumber of Students Who Passed: "
                + passedStudents);

        // Calculate average mark
        double average = marks.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        System.out.printf("Average Mark: %.2f%n", average);

        // Find highest mark
        int highest = marks.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        System.out.println("Highest Mark: " + highest);

        System.out.println("\nProgram completed successfully.");
    }
}
