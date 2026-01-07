package design.patterns.creational.builder;

public class Main {
    public static void main(String[] args) {
        Home home1 = new Home.HomeBuilder().setRooms(5).setWindows(4).setChairs(3).build();
        Home.HomeBuilder builder = new Home.HomeBuilder().setRooms(4).setChairs(3);

        System.out.println(home1);
    }
}
