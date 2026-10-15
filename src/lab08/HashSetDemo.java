package lab08;

import java.util.HashSet;

public class HashSetDemo {

    public static void main(String[] args) {

        // Create a HashSet for student registration numbers
        HashSet<String> students = new HashSet<>();

        // Add registration numbers
        students.add("H250137J");
        students.add("H250138K");
        students.add("H250139L");
        students.add("H250140M");

        // Attempt to add a duplicate
        boolean added = students.add("H250137J");

        System.out.println("Original Student Records:");
        System.out.println(students);

        // Check whether duplicate was added
        System.out.println("\nDuplicate added? " + added);

        // Check whether a student exists
        System.out.println("\nDoes H250137J exist?");
        System.out.println(students.contains("H250137J"));

        // Remove a student
        students.remove("H250139L");

        System.out.println("\nAfter removing H250139L:");
        System.out.println(students);

        // Display number of unique students
        System.out.println("\nTotal unique students: "
                + students.size());

        // Loop through the HashSet
        System.out.println("\nStudent Registration Numbers:");

        for (String student : students) {
            System.out.println(student);
        }
    }
}


