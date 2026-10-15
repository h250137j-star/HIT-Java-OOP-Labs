package lab09;

public class EnumDemo {

    // Enum representing student registration status
    enum StudentStatus {
        REGISTERED,
        PENDING,
        SUSPENDED,
        GRADUATED
    }

    // Student class
    static class Student {

        private String name;
        private StudentStatus status;

        public Student(String name, StudentStatus status) {
            this.name = name;
            this.status = status;
        }

        public void displayDetails() {

            System.out.println("Student Name: " + name);
            System.out.println("Registration Status: " + status);

            // Using switch with an enum
            switch (status) {

                case REGISTERED:
                    System.out.println(
                            "Student is fully registered."
                    );
                    break;

                case PENDING:
                    System.out.println(
                            "Student registration is pending."
                    );
                    break;

                case SUSPENDED:
                    System.out.println(
                            "Student is currently suspended."
                    );
                    break;

                case GRADUATED:
                    System.out.println(
                            "Student has completed studies."
                    );
                    break;
            }
        }
    }

    public static void main(String[] args) {

        Student student1 = new Student(
                "Precious",
                StudentStatus.REGISTERED
        );

        Student student2 = new Student(
                "Tendai",
                StudentStatus.PENDING
        );

        System.out.println("Student 1:");
        student1.displayDetails();

        System.out.println("\nStudent 2:");
        student2.displayDetails();
    }
}
