package design.patterns.behavioral.strategy.with.strategy;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Drive in normal mode");
    }
}
