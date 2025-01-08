package SmallPrograms;

class ConA {
    public ConA(){
        System.out.println("Constructor of Class ConA called!");
    }
}

class ConB extends ConA {
    public ConB(){
       // super(); for calling constructor explicitly : this should be the first line of the constructor.
        // super is useful while creating argument constructor.
        // this constructor when called will call ConA constructor before executing anything.
        this(4); // a constructor can have this or super but not both.
        System.out.println("Constructor of Class ConB called!");
    }

    public ConB(int a){
        System.out.println("Parameterized constructor of ConB called!");
    }
}


public class Constructors {
    public static void main(String[] args) {
        // Sub Class' constructor invokes constructor of Super class.
        // Explicit call to the super class constructor from sub class's constructor can be made using super().

        // as soon as the object is created the constructor of class ConB is called.

        ConB obj = new ConB();

    }
}
