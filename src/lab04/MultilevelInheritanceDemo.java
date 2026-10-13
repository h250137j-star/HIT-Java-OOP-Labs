package lab04;

public class MultilevelInheritanceDemo {

    // Grandparent class
    static class Vehicle {

        public void start() {
            System.out.println("Vehicle is starting.");
        }
    }

    // Child class inherits from Vehicle
    static class Car extends Vehicle {

        public void drive() {
            System.out.println("Car is driving.");
        }
    }

    // Grandchild class inherits from Car
    static class ElectricCar extends Car {

        public void charge() {
            System.out.println("Electric car is charging.");
        }
    }

    public static void main(String[] args) {

        // Create an ElectricCar object
        ElectricCar myCar = new ElectricCar();

        // Method inherited from Vehicle
        myCar.start();

        // Method inherited from Car
        myCar.drive();

        // Method defined in ElectricCar
        myCar.charge();
    }
}

