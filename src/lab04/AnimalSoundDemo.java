package lab04;

public class AnimalSoundDemo {

    // Parent class
    static class SoundAnimal {
        public void makeSound() {
            System.out.println("Animal makes a sound.");
        }
    }

    // Child class Dog
    static class SoundDog extends SoundAnimal {
        @Override
        public void makeSound() {
            System.out.println("Dog barks: Woof Woof!");
        }
    }

    // Child class Cat
    static class SoundCat extends SoundAnimal {
        @Override
        public void makeSound() {
            System.out.println("Cat meows: Meow Meow!");
        }
    }

    public static void main(String[] args) {

        SoundAnimal animal = new SoundAnimal();
        SoundDog dog = new SoundDog();
        SoundCat cat = new SoundCat();

        animal.makeSound();
        dog.makeSound();
        cat.makeSound();
    }
}

