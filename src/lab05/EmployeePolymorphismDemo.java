package lab05;

public class EmployeePolymorphismDemo {

    // Parent class
    static class Employee {
        protected String name;

        public Employee(String name) {
            this.name = name;
        }

        public double calculateSalary() {
            return 0;
        }

        public void displayDetails() {
            System.out.println("Employee: " + name);
            System.out.println("Salary: $" + calculateSalary());
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
        public double calculateSalary() {
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
        public double calculateSalary() {
            return hourlyRate * hoursWorked;
        }
    }

    public static void main(String[] args) {

        // One array stores different employee types
        Employee[] employees = {
                new FullTimeEmployee("Precious", 1500),
                new PartTimeEmployee("Tendai", 10, 80),
                new FullTimeEmployee("Rudo", 1200),
                new PartTimeEmployee("Tariro", 15, 60)
        };

        // Process all employees using one loop
        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println("--------------------");
        }
    }
}
