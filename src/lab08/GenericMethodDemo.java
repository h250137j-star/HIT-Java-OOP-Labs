package lab08;

public class GenericMethodDemo {

    // Generic method to display an array
    public static <T> void displayArray(T[] array) {

        for (T element : array) {
            System.out.println(element);
        }
    }

    // Generic method to return the first element
    public static <T> T getFirstElement(T[] array) {

        if (array.length == 0) {
            throw new IllegalArgumentException(
                    "Array cannot be empty."
            );
        }

        return array[0];
    }

    public static void main(String[] args) {

        // Integer array
        Integer[] numbers = {10, 20, 30, 40};

        // String array
        String[] names = {"Precious", "Tendai", "Rudo"};

        // Double array
        Double[] prices = {12.50, 25.75, 40.00};

        System.out.println("Integer Array:");
        displayArray(numbers);

        System.out.println("\nString Array:");
        displayArray(names);

        System.out.println("\nDouble Array:");
        displayArray(prices);

        // Using a generic method with different types
        System.out.println("\nFirst Integer: "
                + getFirstElement(numbers));

        System.out.println("First Name: "
                + getFirstElement(names));

        System.out.println("First Price: "
                + getFirstElement(prices));
    }
}

