package lab06;

public class DefaultMethodDemo {

    // Interface containing an abstract and a default method
    interface Vehicle {

        // Abstract method
        void start();

        // Default method with an implementation
        default void stop() {
            System.out.println("Vehicle is stopping.");
        }
    }

    // Car uses the default stop() method
    static class Car implements Vehicle {

        @Override
        public void start() {
            System.out.println("Car is starting.");
        }
    }

    // Motorcycle overrides the default stop() method
    static class Motorcycle implements Vehicle {

        @Override
        public void start() {
            System.out.println("Motorcycle is starting.");
        }

        @Override
        public void stop() {
            System.out.println("Motorcycle is stopping safely.");
        }
    }

    public static void main(String[] args) {

        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();

        System.out.println("Car:");
        car.start();
        car.stop();

        System.out.println("\nMotorcycle:");
        motorcycle.start();
        motorcycle.stop();
    }
}

