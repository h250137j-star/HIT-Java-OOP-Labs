package lab08;

public class GenericClassDemo {

    // Generic class that works with different data types
    static class Box<T> {

        private T value;

        // Constructor
        public Box(T value) {
            this.value = value;
        }

        // Getter method
        public T getValue() {
            return value;
        }

        // Setter method
        public void setValue(T value) {
            this.value = value;
        }

        // Display the stored value
        public void display() {
            System.out.println("Stored value: " + value);
        }
    }

    public static void main(String[] args) {

        // Box storing an Integer
        Box<Integer> integerBox = new Box<>(100);

        // Box storing a String
        Box<String> stringBox = new Box<>("Hello Java");

        // Box storing a Double
        Box<Double> doubleBox = new Box<>(45.75);

        System.out.println("Integer Box:");
        integerBox.display();

        System.out.println("\nString Box:");
        stringBox.display();

        System.out.println("\nDouble Box:");
        doubleBox.display();

        // Updating a value using the setter
        integerBox.setValue(200);

        System.out.println("\nUpdated Integer Box:");
        System.out.println("New value: " + integerBox.getValue());
    }
}

