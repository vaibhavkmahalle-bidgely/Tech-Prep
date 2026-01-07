package LLD.patterns.behavioral.strategy.without;

public class SportsVehicle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Drive in sport mode");
    }
}
