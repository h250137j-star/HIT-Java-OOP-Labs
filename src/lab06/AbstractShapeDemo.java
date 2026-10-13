package lab06;

public class AbstractShapeDemo {

    // Abstract parent class
    static abstract class Shape {

        // Abstract method without a body
        public abstract double calculateArea();

        // Concrete method with a body
        public void displayArea() {
            System.out.printf("Area: %.2f%n", calculateArea());
        }
    }

    // Circle subclass
    static class Circle extends Shape {

        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    // Rectangle subclass
    static class Rectangle extends Shape {

        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public double calculateArea() {
            return length * width;
        }
    }

    public static void main(String[] args) {

        // Abstract classes cannot be instantiated directly
        // Shape shape = new Shape();

        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        System.out.println("Circle:");
        circle.displayArea();

        System.out.println("Rectangle:");
        rectangle.displayArea();
    }
}
