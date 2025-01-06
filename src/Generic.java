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
    T thingToPrint;

    public Printer (T thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    void print() {
        System.out.println(thingToPrint);
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
    }
}
