package design.patterns.behavioral.strategy.with;

import design.patterns.behavioral.strategy.with.strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle {
    public PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
