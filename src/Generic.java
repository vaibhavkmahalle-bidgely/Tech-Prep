class IntegerPrinter {
    int thingToPrint;

    // Constructor
    public IntegerPrinter(int thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    void print() {
        System.out.println(thingToPrint);
    }
}

class DoublePrinter {
    double thingToPrint;

    public DoublePrinter(double thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    void print() {
        System.out.println(thingToPrint);
    }
}

class Printer<T> {
    // here T can be replaced by any non primitive object.(String, Array, Object, Lists, Integer(not int), Double(not double), etc)
    T thingToPrint;

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    void print() {
        System.out.println(thingToPrint);
    }
}

// Inheritance in Generic Classes
class ColorPrinter extends Printer<String> {
    //Explicit constructor calling constructor of superclass
    public ColorPrinter(String something) {
        super(something);
    }
}

class NonGenericSubClassKundliPrinter extends Printer<String> {
    public NonGenericSubClassKundliPrinter(String someString)
    {
        super(someString);
    }
}

class GenericSubClassKundliPrinter<T> extends Printer<T>{
   public GenericSubClassKundliPrinter(T something){
       super(something);
   }
}

public class Generic {
    public static void main(String[] args) {

        IntegerPrinter intPrinterObj = new IntegerPrinter(25);
        intPrinterObj.print();

        // If I want to print the same for Double or String then I need to create another class for them by copying the code, that would create code duplication.

        DoublePrinter doublePrinterObj = new DoublePrinter(34.34);
        doublePrinterObj.print();

        // To resolve this issue generics are used in Java.
        Printer<Integer> printIntObj = new Printer<>(55);
        printIntObj.print();

        // Object of ColorPrinter Class
        ColorPrinter colorPrinterObj = new ColorPrinter("Colourful Printer!!");
        colorPrinterObj.print();

        // Object of NonGenericSubClassKundliPrinter Class
        // here we are inheriting the print method from the parent class.
        NonGenericSubClassKundliPrinter kundliPrinterObj = new NonGenericSubClassKundliPrinter("name : Vaibhav, age : 26, color : brightWhite");
        kundliPrinterObj.print();

        // Object of GenericSubClassKundliPrinter
        GenericSubClassKundliPrinter<String> genericSubClassKundliPrinterObj = new GenericSubClassKundliPrinter<>("name : Someone, age : 27, smile : bright&Wide");
        genericSubClassKundliPrinterObj.print();
    }
}
