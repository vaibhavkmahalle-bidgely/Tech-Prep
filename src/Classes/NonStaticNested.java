package Classes;

class NonStaticOuterClass {
    int instanceVariable = 10;
    static int classVariable = 20;

    class MemberInnerClass {
        public void print() {
            System.out.println("InstanceVariable : " + instanceVariable + " ClassVariable : " + classVariable);
        }
    }

    void display(int num) {

        // Local Inner Class is defined within the method, constructor or a block. It is accessible only within the scope it is defined.
        // It cannot be declared private, public or protected.
        class LocalInnerClass {
            void printVal(){
                System.out.println("Number for inner class : "+ num);
            }
        }
        LocalInnerClass LocalInnerObj = new LocalInnerClass();
        LocalInnerObj.printVal();

    }
}

public class NonStaticNested {
    // It has access to all the instance variables and methods of outer class.
    public static void main(String[] args) {

        NonStaticOuterClass NonStaticOuterObj = new NonStaticOuterClass();
        // here we are creating InnerObj using the object of the parent.
        NonStaticOuterClass.MemberInnerClass InnerObj = NonStaticOuterObj.new MemberInnerClass();
        InnerObj.print();
        NonStaticOuterObj.display(55);

        // Anonymous Inner Class
        // Class with No name which you use to instantiate only one object ever at the time of defining the class itself.
        NonStaticOuterClass AnonymousObj = new NonStaticOuterClass(){
            @Override
            void display(int num) {
                System.out.println("We have overridden the method of Nonstatic Outer Class with anonymous Class where object is AnonymousObj, here is the number : "+ num);
            }
        };

        AnonymousObj.display(11);

        Runnable myAnonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm anonymous runnable");
            }
        };

        myAnonymousRunnable.run();

    }


}
