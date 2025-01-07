package SmallPrograms;

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
    // can't initialize the variables directly bcoz : c = 'c';
    // In Java, variable initialization like this must occur:
    //Inside a method, constructor, or initializer block.
    //Directly at the point of declaration (for instance or static variables).

    {
        isSincere = true;
        c = 'c';
    }

    public DataTypesKeywords(){
        b = 1;
        s = 2;
        i = 3;
        l = 4;
    }

    public static void main(String[] args) {
        DataTypesKeywords dataTypes = new DataTypesKeywords();
        System.out.println("Accessing instance variables with help of object : " + dataTypes.isSincere + " , " + dataTypes.c + " , " + dataTypes.b);
        System.out.println("Accessing static variables without object : "+ fl +" , "+ d);
    }
}
