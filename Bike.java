public class Bike extends Vehicle {
    private String modelName = "Activa";    // Car attribute

    public static void main(String[] args) {

        // Create a myCar object
        Bike myBike = new Bike();

        // Call the honk() method (from the Vehicle class) on the myCar object
        myBike.honk();

        // Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class
        System.out.println(myBike.brand + " " + myBike.modelName);
    }
}
