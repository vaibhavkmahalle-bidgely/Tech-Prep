package Exception;

import Classes.Main;
/*
    In java any exception which is thrown is Object of either Throwable class or one of it's child class.
    Throwable is the superclass of all the exceptions which are possible in java.
    There are two types of exceptions : Checked exceptions and Unchecked exceptions.

    Checked exceptions :- All the subclasses of Throwable except RuntimeException and Error, throw this Checked exception which is detected at compile time.
    Unchecked exceptions :- Error Class and RuntimeException these two are the classes which throw Runtime exception which is detected at runtime.


*/

public class ExceptionTypes {
    // Two types - Checked exceptions and Unchecked exceptions
    public static void method1(){
        method2();
    }
    public static void method2(){
        method3();
    }
    public static void method3(){
        method4();
    }public static int method4(){
        return 5/0;
    }

    public static void main(String[] args) {
        method1();
    }
}
