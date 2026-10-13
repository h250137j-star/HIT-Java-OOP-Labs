package lab07;

public class ArithmeticExceptionDemo {

    public static void main(String[] args) {

        int numerator = 20;
        int denominator = 0;

        System.out.println("Program started.");

        try {
            // This statement causes an ArithmeticException
            int result = numerator / denominator;

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {

            // Handle division by zero
            System.out.println("Error: Cannot divide by zero.");

            System.out.println("Exception: " + e.getMessage());
        }

        // Program continues after handling the exception
        System.out.println("Program continues normally.");
    }
}
