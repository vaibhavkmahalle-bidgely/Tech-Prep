package LLD;

import java.util.ArrayList;
import java.util.List;

public class Solid2 {
    // Liskov substitution principle : If Class B is subtype of class A then we should be able to object A with B without breaking the behaviour of the program.
    // Subclass should extend the capability of parent class not narrow it down.
    // Let's say you have Parent -> c1, c2, c3 then
    // Parent pObj = new c1(); code is working fine but now if you do
    // Parent pObj = new c2(); code should not break;

    static class Vehicle {
        public Integer getNumberOfWheels(){
            return 2;
        }

        public Boolean hasEngine(){
            return true;
        }
    }

    static class motorcycle extends Vehicle{

    }

    static class car extends Vehicle{
        @Override
        public Integer getNumberOfWheels(){
            return 4;
        }
    }

    static class cycle extends Vehicle{
        @Override
        public Boolean hasEngine(){
            return null;
        }
    }



    // I - Interfaces should be such, that client should not implement unnecessary functions they do not need.
    // solution divide interface in chote chote tukde

    interface RestaurantEmployee{
        void washDishes();
        void serveCustomers();
        void cookFood();
    }

    class Waiter implements RestaurantEmployee{
       public void washDishes(){
            // Waiter class doesn't need to wash dishes
        }
        public void serveCustomers(){
            System.out.println("Serving customers");
        }
        public void cookFood(){
           // Waiter class doesn't need to cook food.
        }
    }

    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new motorcycle());
        vehicleList.add(new car());
        vehicleList.add((new cycle()));

        for(Vehicle vehicle: vehicleList){
            System.out.println(vehicle.hasEngine().toString());
        }

        // this is fine till now but if we add another vehicle i.e. cycle class
        // now vehicle.hasEngine().toString() will give null pointer exception for cycle class that is breaking the code.

    }


    // D - Dependency Inversion - Class should depend on interface rather than concrete class
}
