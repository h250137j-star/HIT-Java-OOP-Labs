package lab01;

public class Person {

    // Person details
    String name;
    int age;

    // A Person HAS-A Address
    Address address;

    // Constructor
    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public static void main(String[] args) {

        // Create an Address object
        Address homeAddress = new Address(
                "Samora Machel Avenue",
                "Harare",
                "Zimbabwe"
        );

        // Create a Person with an Address
        Person person1 = new Person(
                "Precious",
                21,
                homeAddress
        );

        // Chained dot expression
        System.out.println("Name: " + person1.name);
        System.out.println("City: " + person1.address.city);

        // Create another person without an address
        Person person2 = new Person(
                "Tariro",
                22,
                null
        );

        // Check for null before accessing the address
        if (person2.address == null) {
            System.out.println("Tariro has no address assigned.");
        }

        // Demonstrate what happens if null is accessed
        try {
            System.out.println(person2.address.city);
        } catch (NullPointerException e) {
            System.out.println("Error: Cannot access city because address is null.");
        }
    }
}
