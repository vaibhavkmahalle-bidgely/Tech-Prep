package design.patterns.creational.singleton.eager;

public class SingletonExample {

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();


        obj1.displayValue();
        obj2.displayValue();


    }
}
