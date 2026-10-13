package lab02;

public class Employee {

    // Static counter shared by all employees
    private static int employeeCount = 0;

    // Employee details
    private final int employeeId;
    private String name;
    private String department;
    private double salary;

    // Constructor 1: No arguments
    public Employee() {
        this("Unknown", "Not Assigned", 0.0);
    }

    // Constructor 2: Name only
    public Employee(String name) {
        this(name, "Not Assigned", 0.0);
    }

    // Constructor 3: Full employee details
    public Employee(String name, String department, double salary) {
        employeeCount++;
        this.employeeId = employeeCount;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Copy constructor
    // Creates a new employee with copied details and a new ID
    public Employee(Employee other) {
        this(other.name, other.department, other.salary);
    }

    // Display employee information
    public void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("--------------------");
    }

    public static void main(String[] args) {

        // Using the no-argument constructor
        Employee emp1 = new Employee();

        // Using the name-only constructor
        Employee emp2 = new Employee("Precious");

        // Using the full constructor
        Employee emp3 = new Employee(
                "Tendai", "Software Development", 1500.00
        );

        // Using the copy constructor
        Employee emp4 = new Employee(emp3);

        // Display all employees
        emp1.display();
        emp2.display();
        emp3.display();
        emp4.display();

        System.out.println(
                "Total employees created: " + employeeCount
        );
    }
}
