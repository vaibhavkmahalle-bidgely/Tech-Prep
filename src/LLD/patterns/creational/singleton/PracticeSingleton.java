package LLD.patterns.creational.singleton;

public class PracticeSingleton {
    // volatile objects or members are saved and read from the memory and not CPU core level cache.
    private static volatile PracticeSingleton instance;
    private PracticeSingleton() {

    }

    public static PracticeSingleton getInstance() {
//        synchronized (PracticeSingleton.class) { // aggressive locking : creates poor performance
//            if (instance == null) {
//                instance = new PracticeSingleton();
//            }
//            return instance;
//        }

//       NOT CORRECT if (instance == null) {
//            synchronized (PracticeSingleton.class) {
//                instance = new PracticeSingleton();  // passive locking : good performance still two threads can create instances
//            }
//        }

        if (instance == null) {
            synchronized (PracticeSingleton.class) {
                if (instance == null) {
                    instance = new PracticeSingleton();
                }
            }
        }
        return instance;
    }

}
