package lab09;

public class InnerClassDemo {

    // Outer class
    static class University {

        private String universityName;

        public University(String universityName) {
            this.universityName = universityName;
        }

        // Non-static inner class
        class Student {

            private String studentName;
            private String registrationNumber;

            public Student(String studentName,
                           String registrationNumber) {
                this.studentName = studentName;
                this.registrationNumber = registrationNumber;
            }

            public void displayDetails() {
                System.out.println("University: " + universityName);
                System.out.println("Student Name: " + studentName);
                System.out.println("Registration Number: "
                        + registrationNumber);
            }
        }
    }

    public static void main(String[] args) {

        // Create an outer class object
        University university =
                new University("Harare Institute of Technology");

        // Create an inner class object
        University.Student student =
                university.new Student(
                        "Precious Millicent Zvidi",
                        "H250137J"
                );

        // Display student details
        student.displayDetails();
    }
}
