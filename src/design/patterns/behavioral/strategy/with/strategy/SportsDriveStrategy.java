package design.patterns.behavioral.strategy.with.strategy;

public class SportsDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("drive in sport mode");
    }
}