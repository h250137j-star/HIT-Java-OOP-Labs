package lab08;

import java.util.HashMap;

public class HashMapDemo {

    public static void main(String[] args) {

        // Create a HashMap to store student details
        HashMap<String, String> students = new HashMap<>();

        // Add student registration numbers and names
        students.put("H250137J", "Precious");
        students.put("H250138K", "Tendai");
        students.put("H250139L", "Rudo");
        students.put("H250140M", "Brian");

        // Display all students
        System.out.println("Student Records:");
        System.out.println(students);

        // Retrieve a student using registration number
        System.out.println("\nStudent H250137J:");
        System.out.println(students.get("H250137J"));

        // Update a student's name
        students.put("H250138K", "Tapiwa");

        System.out.println("\nAfter updating:");
        System.out.println(students);

        // Remove a student
        students.remove("H250139L");

        System.out.println("\nAfter removing a student:");
        System.out.println(students);

        // Check if a registration number exists
        System.out.println("\nDoes H250137J exist?");
        System.out.println(students.containsKey("H250137J"));

        // Display the total number of students
        System.out.println("\nTotal students: " + students.size());

        // Loop through all student records
        System.out.println("\nStudent Registration Records:");

        for (String regNumber : students.keySet()) {
            System.out.println(
                    regNumber + " : " + students.get(regNumber)
            );
        }
    }
}
