package lab07;

public class MultipleCatchDemo {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30};

        try {

            // Change this value to test different exceptions
            int choice = 1;

            if (choice == 1) {

                // Arithmetic exception
                int result = 10 / 0;
                System.out.println(result);

            } else if (choice == 2) {

                // Array index exception
                System.out.println(numbers[5]);

            } else if (choice == 3) {

                // Number format exception
                int value = Integer.parseInt("abc");
                System.out.println(value);

            } else {

                System.out.println("No exception occurred.");
            }

        } catch (ArithmeticException e) {

            System.out.println("Arithmetic Error: Division by zero.");

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Array Error: Invalid array index.");

        } catch (NumberFormatException e) {

            System.out.println("Number Format Error: Invalid number.");

        }

        System.out.println("Program completed.");
    }
}
