package lab05;

public class Calculator {

    // Method 1: Add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method 2: Add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method 3: Add two decimal numbers
    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println("Adding two integers: "
                + calc.add(10, 20));

        System.out.println("Adding three integers: "
                + calc.add(10, 20, 30));

        System.out.println("Adding two decimals: "
                + calc.add(5.5, 4.5));
    }
}
