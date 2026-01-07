package javaconcepts.exception;

public class UncheckedExceptions {
    public static void NullPointerExceptionExample() {
            String str = null;
            System.out.println(str.length());
    }

    public static void ArrayIndexOutOfBoundExceptionExample() {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);

    }

    public static void ArithmeticExceptionExample() {
        int result = 10 / 0; // Division by zero
        System.out.println(result);
    }

    public static void NumberFormatExceptionExample() {
        String str = "abc";
        int num = Integer.parseInt(str); // Not a valid number
    }

    public static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative!");
        }
        System.out.println("Age is valid: " + age);
    }
    public static void IllegalArgumentExceptionExample() {
        setAge(-5);
    }

    public static void main(String[] args) {
        //NullPointerExceptionExample();
        //ArrayIndexOutOfBoundExceptionExample();
        //ArithmeticExceptionExample();
        //NumberFormatExceptionExample();
       // IllegalArgumentExceptionExample();
    }
}
