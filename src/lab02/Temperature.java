package lab02;

public class Temperature {
    // Store temperature internally in Celsius
    private final double celsius;

    // Private constructor prevents direct object creation
    private Temperature(double celsius) {
        this.celsius = celsius;
    }

    // Static factory method for Celsius
    public static Temperature fromCelsius(double celsius) {
        return new Temperature(celsius);
    }

    // Static factory method for Fahrenheit
    public static Temperature fromFahrenheit(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        return new Temperature(celsius);
    }

    // Return temperature in Celsius
    public double getCelsius() {
        return celsius;
    }

    // Convert Celsius to Fahrenheit
    public double getFahrenheit() {
        return (celsius * 9.0 / 5.0) + 32;
    }

    // Display temperature
    public void display() {
        System.out.printf("Celsius: %.2f°C%n", getCelsius());
        System.out.printf("Fahrenheit: %.2f°F%n", getFahrenheit());
        System.out.println("--------------------");
    }

    public static void main(String[] args) {

        // Create temperature from Celsius
        Temperature temp1 = Temperature.fromCelsius(25);

        // Create temperature from Fahrenheit
        Temperature temp2 = Temperature.fromFahrenheit(98.6);

        System.out.println("Temperature 1:");
        temp1.display();

        System.out.println("Temperature 2:");
        temp2.display();
    }
}
