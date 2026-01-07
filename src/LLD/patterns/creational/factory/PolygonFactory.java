package design.patterns.creational.factory;

public class PolygonFactory {
    public static Polygon getPolygon(int noOfSides) {
        if (noOfSides == 3) {
            return new Triangle();
        }
        if (noOfSides == 4) {
            return new Square();
        }
        if (noOfSides == 5) {
            return new Pentagon();
        }
        throw new IllegalArgumentException("Can't define polygon with :"+ noOfSides);
    }
}
