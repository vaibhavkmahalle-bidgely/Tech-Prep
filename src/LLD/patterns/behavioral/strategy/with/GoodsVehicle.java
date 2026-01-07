package LLD.patterns.behavioral.strategy.with;

import LLD.patterns.behavioral.strategy.with.strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {
    public GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
