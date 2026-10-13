package lab06;

public class EmployeePaymentDemo {

    // Interface defining a payment contract
    interface Payable {
        double calculatePayment();
    }

    // Abstract class implementing the interface
    static abstract class Employee implements Payable {

        private String name;

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        // Abstract method to be implemented by subclasses
        public abstract double calculatePayment();

        // Concrete method shared by all employees
        public void displayPayment() {
            System.out.println("Employee: " + getName());
            System.out.printf("Payment: $%.2f%n",
                    calculatePayment());
        }
    }

    // Full-time employee
    static class FullTimeEmployee extends Employee {

        private double monthlySalary;

        public FullTimeEmployee(String name, double monthlySalary) {
            super(name);
            this.monthlySalary = monthlySalary;
        }

        @Override
        public double calculatePayment() {
            return monthlySalary;
        }
    }

    // Part-time employee
    static class PartTimeEmployee extends Employee {

        private double hourlyRate;
        private int hoursWorked;

        public PartTimeEmployee(String name,
                                double hourlyRate,
                                int hoursWorked) {
            super(name);
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }

        @Override
        public double calculatePayment() {
            return hourlyRate * hoursWorked;
        }
    }

    public static void main(String[] args) {

        // Array of abstract-class references
        Employee[] employees = {
                new FullTimeEmployee("Precious", 1500),
                new PartTimeEmployee("Tendai", 12, 80),
                new FullTimeEmployee("Rudo", 1200)
        };

        // Process employees using polymorphism
        for (Employee employee : employees) {
            employee.displayPayment();
            System.out.println("--------------------");
        }
    }
}
