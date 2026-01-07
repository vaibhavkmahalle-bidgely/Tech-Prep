package LLD.SOLIDPrinciples.liskov;

public class Main {
    public static void main(String[] args) {

        Engine carEngine = new Engine();
        Engine bikeEngine = new Engine();

        Bicycle bicycle = new Bicycle();
        Vehicle car = new Bicycle();
        Bike bike = new Bike(bikeEngine);

        bicycle.startEngine();
        car.startEngine();
        bike.startEngine();
    }
}
