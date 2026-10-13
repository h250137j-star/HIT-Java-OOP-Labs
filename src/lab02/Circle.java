package lab02;

public class Circle {

    // Instance variable: each circle has its own radius
    private double radius;

    // Static variable: shared by all Circle objects
    private static int count = 0;

    // Exercise 1: Constructor accepting a radius
    public Circle(double radius) {
        this.radius = radius;
        count++;
    }

    // Exercise 1: No-argument constructor
    public Circle() {
        this(1.0); // Calls the constructor above
    }

    // Exercise 2: Static getter for circle count
    public static int getCount() {
        return count;
    }

    // Calculate area
    public double area() {
        return Math.PI * radius * radius;
    }

    // Display circle information
    public void display() {
        System.out.println("Radius: " + radius);
        System.out.printf("Area: %.2f%n", area());
        System.out.println("--------------------");
    }

    public static void main(String[] args) {

        // Create circle using parameterised constructor
        Circle circle1 = new Circle(5.0);

        // Create circle using no-argument constructor
        Circle circle2 = new Circle();

        // Create another circle
        Circle circle3 = new Circle(3.0);

        // Display details
        circle1.display();
        circle2.display();
        circle3.display();

        // Display total number of circles
        System.out.println(
                "Total circles created: " + Circle.getCount()
        );
    }
}
