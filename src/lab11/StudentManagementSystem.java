package lab11;

import java.util.ArrayList;
import java.util.Scanner;

// Abstract parent class
abstract class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayDetails();
}

// Student inherits from Person
class Student extends Person {

    private String registrationNumber;
    private double mark;

    public Student(String name, String registrationNumber,
                   double mark) {

        super(name);
        this.registrationNumber = registrationNumber;
        this.mark = mark;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getGrade() {

        if (mark >= 75) {
            return "A";
        } else if (mark >= 65) {
            return "B";
        } else if (mark >= 50) {
            return "C";
        } else if (mark >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    @Override
    public void displayDetails() {

        System.out.println("Name: " + getName());
        System.out.println("Registration Number: "
                + registrationNumber);
        System.out.println("Mark: " + mark);
        System.out.println("Grade: " + getGrade());
        System.out.println("---------------------------");
    }
}

// Main application
public class StudentManagementSystem {

    private static final ArrayList<Student> students =
            new ArrayList<>();

    private static final Scanner scanner =
            new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\nSTUDENT MANAGEMENT SYSTEM");
            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    registerStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    System.out.println(
                            "Thank you for using the system."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Try again."
                    );
            }

        } while (choice != 4);

        scanner.close();
    }

    // Safely read integer input
    private static int readInt(String prompt) {

        while (true) {

            System.out.print(prompt);

            try {
                return Integer.parseInt(
                        scanner.nextLine().trim()
                );
            } catch (NumberFormatException e) {
                System.out.println(
                        "Please enter a valid whole number."
                );
            }
        }
    }

    // Safely read student marks
    private static double readMark() {

        while (true) {

            System.out.print("Enter student mark (0-100): ");

            try {

                double mark = Double.parseDouble(
                        scanner.nextLine().trim()
                );

                if (Double.isFinite(mark)
                        && mark >= 0 && mark <= 100) {
                    return mark;
                }

                System.out.println(
                        "Mark must be between 0 and 100."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    // Register a student
    private static void registerStudent() {

        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Student name cannot be empty.");
            return;
        }

        System.out.print("Enter registration number: ");
        String regNumber = scanner.nextLine().trim();

        if (regNumber.isEmpty()) {
            System.out.println(
                    "Registration number cannot be empty."
            );
            return;
        }

        for (Student student : students) {

            if (student.getRegistrationNumber()
                    .equalsIgnoreCase(regNumber)) {

                System.out.println(
                        "Registration number already exists."
                );
                return;
            }
        }

        double mark = readMark();

        Student student =
                new Student(name, regNumber, mark);

        students.add(student);

        System.out.println(
                "Student registered successfully!"
        );
    }

    // Display all students
    private static void viewStudents() {

        if (students.isEmpty()) {

            System.out.println("No students registered.");
            return;
        }

        System.out.println("\nREGISTERED STUDENTS");
        System.out.println("---------------------------");

        for (Student student : students) {

            // Polymorphism: Student referenced as Person
            Person person = student;
            person.displayDetails();
        }
    }

    // Search for a student
    private static void searchStudent() {

        System.out.print("Enter registration number: ");
        String regNumber = scanner.nextLine().trim();

        for (Student student : students) {

            if (student.getRegistrationNumber()
                    .equalsIgnoreCase(regNumber)) {

                System.out.println("\nStudent Found:");
                student.displayDetails();
                return;
            }
        }

        System.out.println("Student not found.");
    }
}
