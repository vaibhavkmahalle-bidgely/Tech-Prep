package LLD.patterns.creational.singleton.billpugh;

public class Singleton {
    private  Singleton() {

    }

    // static inner class never gets created until it is called for the first time
    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
