package lab03;

public class TemperatureConverter {

    // Private field to store temperature in Celsius
    private double celsius;

    // Constructor
    public TemperatureConverter(double celsius) {
        setCelsius(celsius);
    }

    // Getter for Celsius
    public double getCelsius() {
        return celsius;
    }

    // Setter with validation
    public void setCelsius(double celsius) {
        if (Double.isFinite(celsius) && celsius >= -273.15) {
            this.celsius = celsius;
        } else {
            System.out.println("Invalid temperature!");
        }
    }

    // Convert Celsius to Fahrenheit
    public double getFahrenheit() {
        return (celsius * 9.0 / 5.0) + 32;
    }

    // Set temperature using Fahrenheit
    public void setFahrenheit(double fahrenheit) {
        if (!Double.isFinite(fahrenheit)) {
            System.out.println("Invalid temperature!");
            return;
        }

        double converted = (fahrenheit - 32) * 5.0 / 9.0;
        setCelsius(converted);
    }

    // Display temperature
    public void display() {
        System.out.printf("Celsius: %.2f°C%n", getCelsius());
        System.out.printf("Fahrenheit: %.2f°F%n", getFahrenheit());
    }

    public static void main(String[] args) {

        TemperatureConverter temp =
                new TemperatureConverter(25);

        System.out.println("Original Temperature:");
        temp.display();

        // Update using Fahrenheit
        temp.setFahrenheit(98.6);

        System.out.println("\nUpdated Temperature:");
        temp.display();

        // Test validation
        temp.setCelsius(-300);

        System.out.println("\nAfter Invalid Update:");
        temp.display();
    }
}
