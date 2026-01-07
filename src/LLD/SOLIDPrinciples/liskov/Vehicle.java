package SOLID.liskov;

public class Vehicle {
    protected Engine engine;

    public Vehicle() {

    }


    public void startEngine() {
        engine.start();
    }
}
