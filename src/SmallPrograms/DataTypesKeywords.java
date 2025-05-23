package SmallPrograms;

class TypeConversion {
    int a = 10;
    float b = 10.2f;
    double c = 1.2;

    // float b = 2.3; not allowed bcoz the narrowing conversion is not allowed
    {
        // WIDENING conversion lower datatype converted to higher.
        // b = a ;

        // NARROWING conversion
        // a = b; not allowed as the precision is lost
        a = (int) c;

    }
}

public class DataTypesKeywords {

    // declaring variables in java
    boolean isSincere;
    char c;
    byte b;
    short s;
    int i;
    long l;
    static float fl = 3.45f;
    static double d = 4.53;

    // initializing variables in java
    //  c = 'c';
    // can't initialize the variables directly bcoz :
    // In Java, variable initialization like this must occur:
    // Inside a method, constructor, or initializer block.
    // Directly at the point of declaration (for instance or static variables).

    {
        isSincere = true;
        c = 'c';
    }

    public DataTypesKeywords() {
        b = 1;
        s = 2;
        i = 3;
        l = 4;
    }

    public static void main(String[] args) {
        DataTypesKeywords dataTypes = new DataTypesKeywords();
        System.out.println("Accessing instance variables with help of object : " + dataTypes.isSincere + " , " + dataTypes.c + " , " + dataTypes.b);
        System.out.println("Accessing static variables without object : " + fl + " , " + d);

        TypeConversion convertType = new TypeConversion();
        System.out.println(convertType.a);
        System.out.println(convertType.b);
        System.out.println(convertType.c);
    }
}
