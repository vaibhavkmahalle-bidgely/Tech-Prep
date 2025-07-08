package LLD.StrategyPattern.withStrategyPattern;

import LLD.StrategyPattern.withStrategyPattern.strategy.DriveStrategy;

public class Vehicle {
    // object of DriveStrategy interface
    // this object is not initialized with any class because then it will be bound to that class and then we will have to create object for each class
    DriveStrategy driveObj;

    // this is constructor injection
    public Vehicle(DriveStrategy driveObj){
        this.driveObj = driveObj;
    }

    public void drive(){
        driveObj.drive();
    }
}
