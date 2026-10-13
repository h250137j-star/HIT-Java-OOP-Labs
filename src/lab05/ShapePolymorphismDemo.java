package lab05;

public class ShapePolymorphismDemo {


    // Parent class
    static class Shape {

        public double calculateArea() {
            return 0;
        }

        public void displayArea() {
            System.out.printf("Area: %.2f%n", calculateArea());
        }
    }

    // Child class: Circle
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

    // Child class: Rectangle
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

    // Child class: Triangle
    static class Triangle extends Shape {

        private double base;
        private double height;

        public Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        @Override
        public double calculateArea() {
            return 0.5 * base * height;
        }
    }

    public static void main(String[] args) {

        // Polymorphic array
        Shape[] shapes = {
                new Circle(5),
                new Rectangle(4, 6),
                new Triangle(8, 3)
        };

        String[] shapeNames = {
                "Circle", "Rectangle", "Triangle"
        };

        // Process all shapes using one loop
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Shape: " + shapeNames[i]);
            shapes[i].displayArea();
            System.out.println("--------------------");
        }
    }
}
