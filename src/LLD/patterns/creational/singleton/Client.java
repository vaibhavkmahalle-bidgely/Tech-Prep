package LLD.patterns.creational.singleton;

public class Client {
    public static void main(String[] args) {
        PracticeSingleton singleton1 = PracticeSingleton.getInstance();
        PracticeSingleton singleton2 = PracticeSingleton.getInstance();

        System.out.println("Singleton 1: " + singleton1);
        System.out.println("Singleton 2: " + singleton2);
    }
}
