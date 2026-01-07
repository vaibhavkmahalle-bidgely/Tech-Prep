package LLD.patterns.creational.builder;

public class Home {
    private int rooms;
    private int windows;
    private int doors;
    private int washrooms;
    private int fans;
    private int chairs;

    private Home(HomeBuilder builder){
        this.rooms = builder.rooms;
        this.doors = builder.doors;
        this.windows = builder.windows;
        this.washrooms = builder.washrooms;
        this.fans = builder.fans;
        this.chairs = builder.chairs;
    }

    @Override
    public String toString() {
        return "Home{" +
                "rooms=" + rooms +
                ", windows=" + windows +
                ", doors=" + doors +
                ", washrooms=" + washrooms +
                ", fans=" + fans +
                ", chairs=" + chairs +
                '}';
    }

    public static class HomeBuilder {
        private int rooms;
        private int windows;
        private int doors;
        private int washrooms;
        private int fans;
        private int chairs;

        public HomeBuilder setRooms(int rooms) {
            this.rooms = rooms;
            return this;
        }

        public HomeBuilder setWindows(int windows) {
            this.windows = windows;
            return this;
        }

        public HomeBuilder setDoors(int doors) {
            this.doors = doors;
            return this;
        }

        public HomeBuilder setWashrooms(int washrooms) {
            this.washrooms = washrooms;
            return this;
        }

        public HomeBuilder setFans(int fans) {
            this.fans = fans;
            return this;
        }

        public HomeBuilder setChairs(int chairs) {
            this.chairs = chairs;
            return this;
        }

        public Home build() {
            return new Home(this);
        }
    }
}


