package LLD.patterns.creational.singleton.eager;


public class Singleton {
    // eager initialization : consumes a lot of memory
    private static Singleton instance = new Singleton();
    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    public void displayValue() {
        System.out.println("Calling Normal Class");
    }
}

