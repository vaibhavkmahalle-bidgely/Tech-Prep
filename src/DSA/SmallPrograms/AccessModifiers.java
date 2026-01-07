package dsa.smallprograms;

public class AccessModifiers {

    private int l, b, h;
    // private, protected, public, default
    // if we don't define any accessModifier that means it is default.

    // Class :
    // outer class : public or default
    // inner class : public, private, protected or default(i.e. package private : accessible in same package but not otherwise)

    // Member Variables and functions :
    // private : accessible from the same class
    // protected : accessible from same package and child class of other package.
    // public  : accessible from any class of any package
    // default : accessible from the class of same package

    // constructor , no return type, name same as class name
    public AccessModifiers(){
        l=1;
        b=2;
        h=3;
    }

    // constructor overloading
    public AccessModifiers(int l, int b, int h){
        this.l = l;
        this.b = b;
        this.h = h;
    }

    public static void main(String[] args) {
        AccessModifiers a = new AccessModifiers(); // called constructor as soon as object is created
        // creating an object assigns the memory and allocates values 0,0,0 to all l,b,h
        // but to represent a real world entity object must be initialized properly hence constructor is introduced.
        // let's say a box with l,b,h as 0,0,0 doesn't make sense so person who is defining a class can decide what the properties must be initialized with while creating an object.

        System.out.println("value of l, b, h : "+ a.l + "," + a.b + "," + a.h);

        AccessModifiers br = new AccessModifiers(4,5,6);
        System.out.println("value of l, b, h : "+ br.l + "," + br.b + "," + br.h);
    }

}
