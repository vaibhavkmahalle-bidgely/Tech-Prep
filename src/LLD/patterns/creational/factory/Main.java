package LLD.patterns.creational.factory;

/* design your code for behaviours rather than implementation */

public class Main {
    public static void main(String[] args) {
        Polygon triangle = PolygonFactory.getPolygon(3);
        Polygon square = PolygonFactory.getPolygon(4);
        Polygon pentagon = PolygonFactory.getPolygon(5);

        triangle.draw();
        square.draw();
        pentagon.draw();
    }
}
