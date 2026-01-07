package javaconcepts.exception;

import classes.Main;

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
