package SmallPrograms;

class A{
   void print(int a){
       System.out.println("you're in class A "+ a);
   }
}

class B extends A {
    void print(String b){
        System.out.println("You're in class B "+ b);
    }
}

public class OverloadingandOverriding {
    // if two methods (whether both declared in the same class, or both inherited by a class, or one declared one inherited) have the same name but the signatures are not same, then the method name is overloaded.
    // method overloading is a way to implement polymorphism

    public static void main(String[] args) {
        B obj = new B();
        obj.print(5);
        obj.print("Hello");

    }


}
