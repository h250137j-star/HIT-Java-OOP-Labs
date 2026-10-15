package lab10;

public class LambdaExpressionDemo {

    // Functional interface
    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
    }

    // Another functional interface
    @FunctionalInterface
    interface Greeting {
        void greet(String name);
    }

    public static void main(String[] args) {

        // Lambda expression for addition
        Calculator addition = (a, b) -> a + b;

        // Lambda expression for multiplication
        Calculator multiplication = (a, b) -> a * b;

        // Lambda expression for subtraction
        Calculator subtraction = (a, b) -> a - b;

        // Lambda expression for greeting
        Greeting greeting = name ->
                System.out.println("Welcome, " + name + "!");

        System.out.println("Lambda Expression Results:");

        System.out.println("Addition: "
                + addition.calculate(10, 5));

        System.out.println("Multiplication: "
                + multiplication.calculate(10, 5));

        System.out.println("Subtraction: "
                + subtraction.calculate(10, 5));

        System.out.println();

        greeting.greet("Precious");

        System.out.println("\nProgram completed successfully.");
    }
}

