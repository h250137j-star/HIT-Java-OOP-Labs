package lab03;

public class Student {
    // Private fields: cannot be accessed directly outside the class
    private String name;
    private int age;
    private double grade;

    // Constructor
    public Student(String name, int age, double grade) {
        this.name = name;
        setAge(age);
        setGrade(grade);
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter with validation
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age!");
        }
    }

    // Getter for grade
    public double getGrade() {
        return grade;
    }

    // Setter with validation
    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        } else {
            System.out.println("Invalid grade!");
        }
    }

    // Display student information
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {

        Student student1 = new Student(
                "Precious", 20, 85.5
        );

        System.out.println("Original Student Details:");
        student1.display();

        // Update values using setters
        student1.setAge(21);
        student1.setGrade(90);

        System.out.println("\nUpdated Student Details:");
        student1.display();

        // Test validation
        student1.setAge(-5);
        student1.setGrade(120);
    }
}
