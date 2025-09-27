package design.patterns.creational.singleton;

public class Singleton {
    private static Singleton instance = null;
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(); // double checking lock -> lazy initialization
                }
            }
        }
        return instance;
    }

    public void displayValue() {
        System.out.println("Calling Normal Class");
    }
}
