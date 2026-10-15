package lab08;

import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {

        // Create an ArrayList to store student names
        ArrayList<String> students = new ArrayList<>();

        // Add elements to the ArrayList
        students.add("Precious");
        students.add("Tendai");
        students.add("Rudo");
        students.add("Tapiwa");

        // Display all students
        System.out.println("Original student list:");
        System.out.println(students);

        // Access an element using its index
        System.out.println("\nFirst student: " + students.get(0));

        // Update an element
        students.set(1, "Brian");

        System.out.println("\nAfter updating:");
        System.out.println(students);

        // Remove an element
        students.remove("Rudo");

        System.out.println("\nAfter removing Rudo:");
        System.out.println(students);

        // Display the number of students
        System.out.println("\nNumber of students: " + students.size());

        // Loop through the ArrayList
        System.out.println("\nStudent names:");

        for (String student : students) {
            System.out.println(student);
        }
    }
}
