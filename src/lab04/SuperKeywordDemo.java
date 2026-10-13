package lab04;

public class SuperKeywordDemo {

    // Parent class
    static class Person {

        protected String name;

        // Parent constructor
        public Person(String name) {
            this.name = name;
            System.out.println("Person constructor called.");
        }

        public void display() {
            System.out.println("Name: " + name);
        }
    }

    // Child class
    static class Student extends Person {

        private String registrationNumber;

        // Child constructor
        public Student(String name, String registrationNumber) {

            // Call parent constructor
            super(name);

            this.registrationNumber = registrationNumber;
            System.out.println("Student constructor called.");
        }

        // Override parent method
        @Override
        public void display() {

            // Call parent's display method
            super.display();

            System.out.println(
                    "Registration Number: " + registrationNumber
            );
        }
    }

    public static void main(String[] args) {

        Student student = new Student(
                "Precious Millicent Zvidi",
                "H250137J"
        );

        System.out.println("\nStudent Details:");
        student.display();
    }
}
