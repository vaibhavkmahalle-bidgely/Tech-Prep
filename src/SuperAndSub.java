class Vehicle {
    // SuperClass
    String brand;
    int wheels;

    // constructor
    public Vehicle(String brand, int wheels){
        this.brand = brand;
        this.wheels = wheels;
    }

    // method of superclass
    void displayInfo(){
        System.out.println("This vehicle is of " + brand +" and has "+ wheels + " wheels.");
    }
}

class Car extends Vehicle {
    // Subclass
    int doors ;

    // constructor
    public Car(String brand, int wheels, int doors){
        super(brand, wheels);
        this.doors = doors;
    }
    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("This is a Car!");
    }

}

public class SuperAndSub {
    // This is the main class
    // In java Object is the implicit super class of all the classes.
    public static void main(String[] args) {
    Car Honda = new Car("civic",4,4);

       Honda.displayInfo();

    }


}
