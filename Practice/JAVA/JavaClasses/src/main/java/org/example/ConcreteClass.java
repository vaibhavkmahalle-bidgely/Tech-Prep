package org.example;

public class ConcreteClass {
    // Class in which all the methods have implementation is called ConcreteClass.
    // i.e. Class with definitions for all the methods.
    // You can create objects of a concrete class using the new keyword.
    // A concrete class can inherit from an abstract class or implement an interface, but it must provide implementations for all inherited abstract methods.

    String name ;
    int age ;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        ConcreteClass ClassObj = new ConcreteClass();

        ClassObj.setAge(10);
        System.out.println("My age is "+ ClassObj.age);
    }
}
