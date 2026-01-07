package dsa.smallprograms;

import classes.Concrete;

public class WrapperClass {
    public static void main(String[] args) {
        Integer i = Integer.valueOf("123");// as valueOf is a static method of Integer class we access it using ClassName.methodName .
        System.out.println(i);

        // parseXXX this method is used for converting string type to xxx type where xxx is primitive type

        int a = Integer.parseInt("111");
        System.out.println(a);

        double b = Double.parseDouble("1.23");
        System.out.println(b);

        Integer i1 = Integer.valueOf("101011", 2);
        // now i1 is a variable of Integer class type but if you want to get this integer value in primitive type then
        int c = i1.intValue();
        System.out.println(c);
        System.out.println(i1);

        for (String arg : args) {
            System.out.println(arg);
        }

        Concrete importedObj = new Concrete();
        importedObj.setAge(123);
        System.out.println("My age is "+ importedObj.age);
    }
}
