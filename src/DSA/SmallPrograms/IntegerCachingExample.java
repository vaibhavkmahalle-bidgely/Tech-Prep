package SmallPrograms;

public class IntegerCachingExample {

    public static void main(String[] args) {
        Integer a = 127;
        Integer x = 128;
        Integer b = 127;
        Integer y = 128;

        if (a == b) {
            System.out.println("a and b are equal");
        } else {
            System.out.println("a and b are not equal");
        }

        if (x == y) {
            System.out.println("x and y are equal");
        } else {
            System.out.println("x and y are not equal");
        }
    }
}
