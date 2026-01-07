package LLD.patterns.behavioral.strategy.with;

import LLD.patterns.behavioral.strategy.with.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
