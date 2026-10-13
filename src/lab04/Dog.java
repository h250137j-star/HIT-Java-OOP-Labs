package lab04;

public class Dog extends Animal {

        public Dog(String name) {
            super(name);
        }

        public void bark() {
            System.out.println(name + " is barking.");
        }

        public static void main(String[] args) {

            Dog dog = new Dog("Buddy");

            dog.eat();
            dog.bark();
        }
    }




