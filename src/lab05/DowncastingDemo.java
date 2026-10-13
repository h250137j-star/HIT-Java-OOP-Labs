package lab05;

public class DowncastingDemo {

    // Parent class
    static class Animal {
        public void eat() {
            System.out.println("Animal is eating.");
        }
    }

    // Child class Dog
    static class Dog extends Animal {
        public void bark() {
            System.out.println("Dog is barking.");
        }
    }

    // Child class Cat
    static class Cat extends Animal {
        public void meow() {
            System.out.println("Cat is meowing.");
        }
    }

    public static void main(String[] args) {

        // Upcasting: child objects stored as Animal references
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        animal1.eat();
        animal2.eat();

        // Check type before downcasting
        if (animal1 instanceof Dog) {
            Dog dog = (Dog) animal1;
            dog.bark();
        }

        if (animal2 instanceof Cat) {
            Cat cat = (Cat) animal2;
            cat.meow();
        }

        // Prevent an invalid cast
        if (animal1 instanceof Cat) {
            Cat cat = (Cat) animal1;
            cat.meow();
        } else {
            System.out.println(
                    "animal1 is not a Cat. Casting avoided."
            );
        }
    }
}
