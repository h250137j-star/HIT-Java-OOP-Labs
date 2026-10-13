package lab01;

import java.time.Year;

public class Car {

    // Fields describing a car
    String brand;
    int year;
    double mileage;

    // Exercise 1: Display car details
    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Mileage: " + mileage + " km");
        System.out.println("--------------------");
    }

    // Exercise 2: Check whether a car is antique
    boolean isAntique() {
        int currentYear = Year.now().getValue();
        return (currentYear - year) > 25;
    }

    public static void main(String[] args) {

        // Create the first car
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.year = 1995;
        car1.mileage = 250000;

        // Create the second car
        Car car2 = new Car();
        car2.brand = "Honda";
        car2.year = 2015;
        car2.mileage = 120000;

        // Create the third car
        Car car3 = new Car();
        car3.brand = "Mercedes-Benz";
        car3.year = 1988;
        car3.mileage = 310000;

        // Display the three cars
        car1.display();
        car2.display();
        car3.display();

        // Check whether each car is antique
        System.out.println("Toyota antique? " + car1.isAntique());
        System.out.println("Honda antique? " + car2.isAntique());
        System.out.println("Mercedes-Benz antique? " + car3.isAntique());
    }
}
