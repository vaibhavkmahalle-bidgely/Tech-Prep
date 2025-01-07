package SmallPrograms;

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
        hi();
        StaticVariablesAndFunctions.hi();

    }

}
