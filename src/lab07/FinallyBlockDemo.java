package lab07;

public class FinallyBlockDemo {

    public static void main(String[] args) {

        System.out.println("Program started.");

        try {

            int numerator = 20;
            int denominator = 0;

            int result = numerator / denominator;

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {

            System.out.println("Error: Cannot divide by zero.");

        } finally {

            System.out.println("Finally block executed.");
            System.out.println("Cleanup completed.");

        }

        System.out.println("Program ended.");
    }
}
