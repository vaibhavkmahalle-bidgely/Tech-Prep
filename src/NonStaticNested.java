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
        NonStaticOuterClass.MemberInnerClass InnerObj = NonStaticOuterObj.new MemberInnerClass();
        // here we are creating InnerObj using the object of the parent.

        InnerObj.print();
        NonStaticOuterObj.display(55);
    }


}
