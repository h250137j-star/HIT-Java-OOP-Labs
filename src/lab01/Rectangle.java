package lab01;

public class Rectangle {

    // Fields
    double width;
    double height;

    // Calculate area
    double area() {
        return width * height;
    }

    // Calculate perimeter
    double perimeter() {
        return 2 * (width + height);
    }

    public static void main(String[] args) {

        // Create an array of five rectangles
        Rectangle[] rectangles = new Rectangle[5];

        // Create and initialise each rectangle
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new Rectangle();
            rectangles[i].width = (i + 1) * 2;
            rectangles[i].height = (i + 1) * 3;
        }

        // Assume the first rectangle has the largest area
        Rectangle largest = rectangles[0];

        // Display rectangles and find the largest
        for (Rectangle r : rectangles) {
            System.out.println("Width: " + r.width);
            System.out.println("Height: " + r.height);
            System.out.println("Area: " + r.area());
            System.out.println("Perimeter: " + r.perimeter());
            System.out.println("--------------------");

            if (r.area() > largest.area()) {
                largest = r;
            }
        }

        // Display rectangle with largest area
        System.out.println("Rectangle with largest area:");
        System.out.println("Width: " + largest.width);
        System.out.println("Height: " + largest.height);
        System.out.println("Area: " + largest.area());
    }
}
