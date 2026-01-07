package SmallPrograms;

public class InitializationBlock {
    private int value;

    // Static variable
    private static int staticValue;

    // Static Initialization Block
    static {
        System.out.println("Static Initialization Block executed.");
        staticValue = 100; // Initialize staticValue
    }


    // Constructor
    public InitializationBlock() {
        System.out.println("constructor executed : ");
        System.out.println("Value : " + value);
    }

    // Instance Initialization Block
    {
        System.out.println("Instance Initialization Block executed.");
        value = 10; // Initialize value
    }

    public static void main(String[] args) {
        System.out.println("Creating first object:");
        InitializationBlock obj1 = new InitializationBlock();

        System.out.println("\nCreating second object:");
        InitializationBlock obj2 = new InitializationBlock();

        System.out.println("Static Value: " + staticValue);
    }
}
