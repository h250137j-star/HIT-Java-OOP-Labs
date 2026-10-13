package lab01;

public class RectangleReferenceDemo {

    public static void main(String[] args) {

        // Create the first rectangle
        Rectangle r1 = new Rectangle();
        r1.width = 10;
        r1.height = 5;

        // Assign r1's reference to r2
        Rectangle r2 = r1;

        // Change width using r2
        r2.width = 20;

        // Display the values
        System.out.println("Width of r1: " + r1.width);
        System.out.println("Width of r2: " + r2.width);

        // Check whether both refer to the same object
        System.out.println("Same object? " + (r1 == r2));
    }
}
