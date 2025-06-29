package LLD;

public class Solid2 {
    // Liskov substitution principle : If Class B is subtype of class A then we should be able to object A with B without breaking the behaviour of the program.
    // Subclass should extend the capability of parent class not narrow it down.



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


    // D - Dependency Inversion - Class should depend on interface rather than concrete class
}
