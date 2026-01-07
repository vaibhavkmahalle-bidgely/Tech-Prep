package LLD.patterns.behavioral.strategy.without;

public class OffRoadVehicle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("drive in sport mode");
    }
}
