package LLD.StrategyPattern.withStrategyPattern.strategy;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Normal Drive capability");
    }
}
