package LLD.StrategyPattern.withoutStrategyPattern;

public class Vehicle {

    // here children of Vehicle i.e SportVehicle and OffRoadVehicle both have similar code but it cannot be shared cos common parent does not have that code
    // that is why we use Strategy Pattern
    public void drive(){
        System.out.println("normal mode");
    }
}
