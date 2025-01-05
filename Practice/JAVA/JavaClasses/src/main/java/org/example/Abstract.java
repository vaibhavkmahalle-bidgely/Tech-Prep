package org.example;


abstract class Shape{
    int x,y;

    // Constructor of the abstract class
    public Shape(int x,int y){
        this.x = x;
        this.y = y;
    }

    void draw(){
        System.out.println("Drawing Shape");
    }

    double area(){
        return 0.0; // default implementation but can be overridden in subclass
    }

}

class Circle extends Shape{
    int radius;

    // constructor of Circle class
    public Circle(int x, int y, int radius){
        super(x,y);
        this.radius = radius;
    }

    @Override
    public void draw(){
        System.out.println("Drawing circle at (x " + x + " and y "+ y +") with radius " + radius );
    }
}

public class Abstract {
    // abstract keyword in class name
    // can have all concrete methods or all abstract or mixed
    // We cannot instantiate (Create object of the Class) this class even if we have all concrete methods bcoz the class name is abstract.
    public static void main(String[] args) {
        Circle CircleObj = new Circle(2,4,5);
        CircleObj.draw();
    }


}
