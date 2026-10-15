package lab09;

public class StaticNestedDemo {

    // Outer class
    static class University {

        private static String universityName =
                "Harare Institute of Technology";

        // Static nested class
        static class Department {

            private String departmentName;
            private String courseName;

            public Department(String departmentName,
                              String courseName) {
                this.departmentName = departmentName;
                this.courseName = courseName;
            }

            public void displayDetails() {
                System.out.println("University: " + universityName);
                System.out.println("Department: " + departmentName);
                System.out.println("Course: " + courseName);
            }
        }
    }

    public static void main(String[] args) {

        // Create a static nested class object directly
        University.Department department =
                new University.Department(
                        "Software Engineering",
                        "Object-Oriented Programming"
                );

        // Display department information
        department.displayDetails();
    }
}
