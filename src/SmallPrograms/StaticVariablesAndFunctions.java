package SmallPrograms;

class Parent{
    public static void f1(){
        System.out.println("hello");
    }
}

class Child extends Parent{
    public static void f1(){
        System.out.println("meow!");
    }
}
// here method f1 from Child hides method f1 from Parent : it is method hiding which is different from method overriding.

public class StaticVariablesAndFunctions {
    private int x = 2; // Instance member variable
    static private int y = 10; // Static member variable

    public void hello() {
        System.out.println("hello there "+ x);
    }

    static public void hi() {
        System.out.println("hi there "+ y );
    }

    public static void main(String[] args) {
        // here x will be created two times separately as x is instance variable and belongs to the object.
        // y will be created only once as it belongs to the class and it is a class variable.
        StaticVariablesAndFunctions obj = new StaticVariablesAndFunctions();
        StaticVariablesAndFunctions obj2 = new StaticVariablesAndFunctions();

        obj.hello();

        Child.f1();

        // Static functions/methods can only access static members of same class.
        hi();
        StaticVariablesAndFunctions.hi();

    }

}
