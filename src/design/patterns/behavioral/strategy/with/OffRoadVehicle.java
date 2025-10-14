package design.patterns.behavioral.strategy.with;

import design.patterns.behavioral.strategy.with.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
