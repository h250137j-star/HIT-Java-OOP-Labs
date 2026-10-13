package lab03;

// final prevents other classes from inheriting this class
public final class ImmutableStudent {
    // Private final fields
    private final String name;
    private final String registrationNumber;
    private final String department;

    // Constructor initializes all fields
    public ImmutableStudent(String name,
                            String registrationNumber,
                            String department) {

        this.name = name;
        this.registrationNumber = registrationNumber;
        this.department = department;
    }

    // Getter methods only
    public String getName() {
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getDepartment() {
        return department;
    }

    // Display student information
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Registration Number: "
                + registrationNumber);
        System.out.println("Department: " + department);
    }

    public static void main(String[] args) {

        // Create an immutable student object
        ImmutableStudent student = new ImmutableStudent(
                "Precious Millicent Zvidi",
                "H250137J",
                "Software Engineering"
        );

        student.display();

        // The following would cause a compilation error:
        // student.name = "Another Name";
        // student.setName("Another Name");
    }
}

