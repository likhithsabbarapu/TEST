public class Car extends Vehicle {
    private String modelName = "City";    // Car attribute
    @Override
    public void honk() {                    // Vehicle method
        System.out.println("bonk, tuut!");
    }
    public  void main(String[] args) {



        // Create a myCar object
        Car myCar = new Car();
        Car likCar = new Car();
        Car lalithaCar = new Car();
        super.honk();
        likCar.honk();

        // Call the honk() method (from the Vehicle class) on the myCar object
        myCar.honk();

        // Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class
        System.out.println(myCar.brand + " " + myCar.modelName);
    }
}