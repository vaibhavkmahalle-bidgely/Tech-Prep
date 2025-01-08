package SmallPrograms;

// final keyword for a class is like a nasbandi of that class that class can no longer have children
final class FinalKeyword {
    // final variable can be assigned only once then value can't be changed.
    // variable that is declared as final and not initialized is called blank final variable.
    final int firstwayofInitialization = 4;
    final int secondWay;
    final int thirdWay;
    final static int staticway1 = 1;
    final static int staticway2;

    static
    {
        staticway2 = 1;
    }

    {
        secondWay = 2;
    }

    public FinalKeyword() {
        thirdWay = 3;

    }

    void print(){
        System.out.println("Three ways of initializing final instance variables : " + firstwayofInitialization + "," + secondWay + "," + thirdWay);
        System.out.println("Two ways of initializing final static variables : " + staticway1 + "," + staticway2 );
    }
}

class A {
     void print(int a) {
        System.out.println("you're in class A " + a);

    }
}

class B extends A {
    // in method overloading arguments should be different and name of method should be same.
    void print(String b) {
        System.out.println("You're in class B " + b);

    }
}

// Overriding
class C extends B {
    // here print method from class A is overridden from class C method.
    void print(int a) {
        System.out.println("You're in class C");
    }
}

public class OverloadingandOverriding {
    // if two methods (whether both declared in the same class, or both inherited by a class, or one declared one inherited) have the same name but the signatures are not same, then the method name is overloaded.
    // method overloading is a way to implement polymorphism

    public static void main(String[] args) {
        B obj = new B();
        obj.print(5);
        obj.print("Hello");

        // overriding
        C obj1 = new C();
        obj1.print(5);

        // final keyword
        FinalKeyword finalObj = new FinalKeyword();
        finalObj.print();

    }


}
