package lab05;

public class RuntimePolymorphismDemo {

    // Parent class
    static class Animal {

        public void makeSound() {
            System.out.println("Animal makes a sound.");
        }
    }

    // Child class Dog
    static class Dog extends Animal {

        @Override
        public void makeSound() {
            System.out.println("Dog says: Woof Woof!");
        }
    }

    // Child class Cat
    static class Cat extends Animal {

        @Override
        public void makeSound() {
            System.out.println("Cat says: Meow Meow!");
        }
    }

    public static void main(String[] args) {

        // Parent reference pointing to a Dog object
        Animal animal1 = new Dog();

        // Parent reference pointing to a Cat object
        Animal animal2 = new Cat();

        // Java selects the appropriate method at runtime
        animal1.makeSound();
        animal2.makeSound();
    }
}
