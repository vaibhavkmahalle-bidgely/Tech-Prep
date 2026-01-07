package classes;

public class Concrete {
    // Class in which all the methods have implementation is called Classes.Concrete.
    // i.e. Class with definitions for all the methods.
    // You can create objects of a concrete class using the new keyword.
    // A concrete class can inherit from an abstract class or implement an interface, but it must provide implementations for all inherited abstract methods.

    String name ;
    public int age ;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        Concrete ClassObj = new Concrete();

        ClassObj.setAge(10);
        System.out.println("My age is "+ ClassObj.age);
    }
}