abstract class Animals {
    String name;
    // A constructor (abstract classes can have them!)
    Animals(String name) {
        this.name = name;
    }
    // Abstract method (no body)
    abstract void makeSound();

    // Concrete method (shared logic)
    void sleep() {
        System.out.println(name + " is sleeping... Zzz");
    }
}
class Dog extends Animals {
    Dog(String name) { super(name); }
    // Providing the implementation for the abstract method
    @Override
    void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
}
public class Animal {
    public static void main(String[] args) {
        // Animal myAnimal = new Animal("Generic"); // Error! Cannot instantiate
        Dog myDog = new Dog("Buddy");

        myDog.makeSound(); // Implementation from Dog
        myDog.sleep();     // Inherited logic from Animal
    }
}