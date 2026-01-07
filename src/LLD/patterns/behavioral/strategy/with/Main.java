package LLD.patterns.behavioral.strategy.with;

public class Main {
    public static void main(String[] args) {
        Vehicle offRoadVehicle = new OffRoadVehicle();
        Vehicle passengerVehicle = new PassengerVehicle();
        Vehicle sportsVehicle = new SportsVehicle();
        Vehicle goodsVehicle = new GoodsVehicle();

        offRoadVehicle.drive();
        passengerVehicle.drive();
        sportsVehicle.drive();
        goodsVehicle.drive();
        
    }
}
