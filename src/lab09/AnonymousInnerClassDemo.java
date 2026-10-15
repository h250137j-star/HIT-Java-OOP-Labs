package lab09;

public class AnonymousInnerClassDemo {

    // Interface defining a greeting method
    interface Greeting {
        void greet();
    }

    // Abstract class representing a student
    static abstract class Student {

        public abstract void displayDetails();
    }

    public static void main(String[] args) {

        // Anonymous class implementing an interface
        Greeting greeting = new Greeting() {

            @Override
            public void greet() {
                System.out.println(
                        "Welcome to Harare Institute of Technology!"
                );
            }
        };

        greeting.greet();

        // Anonymous class extending an abstract class
        Student student = new Student() {

            @Override
            public void displayDetails() {
                System.out.println("\nStudent Details:");
                System.out.println("Name: Precious Millicent Zvidi");
                System.out.println("Registration Number: H250137J");
                System.out.println("Department: Software Engineering");
            }
        };

        student.displayDetails();

        System.out.println("\nProgram completed successfully.");
    }
}
