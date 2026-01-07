package LLD.patterns.creational.singleton.lazy;

public class SingletonExample {

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();


        obj1.displayValue();
        obj2.displayValue();


    }
}
