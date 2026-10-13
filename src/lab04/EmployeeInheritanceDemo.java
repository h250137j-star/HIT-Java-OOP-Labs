package lab04;

public class EmployeeInheritanceDemo {

    // Parent class
    static class Employee {
        protected String name;
        protected double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double calculateSalary() {
            return salary;
        }

        public void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("Salary: $" + calculateSalary());
        }
    }

    // Child class
    static class Manager extends Employee {
        private double bonus;

        public Manager(String name, double salary, double bonus) {
            super(name, salary);
            this.bonus = bonus;
        }

        // Override the parent's salary calculation
        @Override
        public double calculateSalary() {
            return super.calculateSalary() + bonus;
        }

        @Override
        public void displayDetails() {
            System.out.println("Position: Manager");
            super.displayDetails();
            System.out.println("Bonus: $" + bonus);
        }
    }

    public static void main(String[] args) {

        Employee employee = new Employee("Tendai", 800);
        Manager manager = new Manager("Precious", 1500, 300);

        System.out.println("Employee Details:");
        employee.displayDetails();

        System.out.println("\nManager Details:");
        manager.displayDetails();
    }
}
