package LLD.patterns.behavioral.strategy.with;

import LLD.patterns.behavioral.strategy.with.strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
