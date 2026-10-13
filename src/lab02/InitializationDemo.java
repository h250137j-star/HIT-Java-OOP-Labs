package lab02;

public class InitializationDemo {

    // First static initialiser block
    static {
        System.out.println("Static Block 1");
    }

    // Second static initialiser block
    static {
        System.out.println("Static Block 2");
    }

    // First instance initialiser block
    {
        System.out.println("Instance Block 1");
    }

    // Second instance initialiser block
    {
        System.out.println("Instance Block 2");
    }

    // Constructor
    public InitializationDemo() {
        System.out.println("Constructor Executed");
    }

    public static void main(String[] args) {

        System.out.println("Creating First Object:");
        InitializationDemo obj1 = new InitializationDemo();

        System.out.println("Creating Second Object:");
        InitializationDemo obj2 = new InitializationDemo();
    }
}
