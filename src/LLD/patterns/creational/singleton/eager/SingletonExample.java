package LLD.patterns.creational.singleton.eager;

public class SingletonExample {

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        // Verify both references point to the same instance
        System.out.println("obj1 hashCode: " + obj1.hashCode());
        System.out.println("obj2 hashCode: " + obj2.hashCode());
        System.out.println("Are they the same instance? " + (obj1 == obj2));
        System.out.println();

        obj1.displayValue();
        obj2.displayValue();
    }
}
