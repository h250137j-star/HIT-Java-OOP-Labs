package lab09;

public class RecordDemo {

    // Record representing student information
    record Student(
            String name,
            String registrationNumber,
            String department
    ) {}

    public static void main(String[] args) {

        // Create student records
        Student student1 = new Student(
                "Precious Millicent Zvidi",
                "H250137J",
                "Software Engineering"
        );

        Student student2 = new Student(
                "Tendai",
                "H250138K",
                "Computer Science"
        );

        // Access record components
        System.out.println("Student 1 Details:");
        System.out.println("Name: " + student1.name());
        System.out.println("Registration Number: "
                + student1.registrationNumber());
        System.out.println("Department: "
                + student1.department());

        // Automatically generated toString()
        System.out.println("\nStudent 2 Details:");
        System.out.println(student2);

        // Compare records
        Student student3 = new Student(
                "Precious Millicent Zvidi",
                "H250137J",
                "Software Engineering"
        );

        System.out.println("\nAre student1 and student3 equal?");
        System.out.println(student1.equals(student3));
    }
}
