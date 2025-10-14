package design.patterns.behavioral.strategy.without;

public class PassengerVehicle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Drive in normal mode");
    }
}
