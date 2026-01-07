package LLD.patterns.behavioral.strategy.without;

public class GoodsVehicle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Drive in normal mode");
    }
}
