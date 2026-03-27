class Animal2 {
    public void animalSound() {
        System.out.println("The animal makes a sound");
    }
}

class Dogs extends Animal2 {
    public void animalSound() {
        super.animalSound(); // Call the parent method
        System.out.println("The dog says: bow wow");
    }
}

public class Sound {
    public static void main(String[] args) {
        Dogs myDog = new Dogs();
        myDog.animalSound();
    }
}