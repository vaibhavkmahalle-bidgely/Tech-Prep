package classes;

abstract class Shape{
    int x,y;

    // Constructor of the abstract class
    public Shape(int x,int y){
        this.x = x;
        this.y = y;
    }

    void draw(){
        System.out.println("Drawing Classes.Shape");
    }

    double area(){
        return 0.0; // default implementation but can be overridden in subclass
    }

    abstract int volume();
}

class Circle extends Shape{
    int radius;

    // constructor of Classes.Circle class
    public Circle(int x, int y, int radius){
        super(x,y);
        this.radius = radius;
    }

    public int Volume(){
        return 1;
    }

    @Override
    public void draw(){
        System.out.println("Drawing circle at (x " + x + " and y "+ y +") with radius " + radius );
    }

    @Override
    int volume() {
        return 0;
    }
}

public class Abstract {
    // abstract keyword in class name
    // can have all concrete methods or all abstract or mixed
    // We cannot instantiate (Create object of the Class) this class even if we have all concrete methods bcoz the class name is abstract.
    // Abstract class mainly used as a parent class from which we can create child classes.
    // If we want to refer to the parent class we can create the Object of child class with reference of parent class.
    public static void main(String[] args) {
        Circle CircleObj = new Circle(2,4,5);
        CircleObj.draw();
    }


}
