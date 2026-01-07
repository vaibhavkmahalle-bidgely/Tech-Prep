// lazy initializtion

package LLD.patterns.creational.singleton.lazy;

public class Singleton {
    private static volatile Singleton instance = null;
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
