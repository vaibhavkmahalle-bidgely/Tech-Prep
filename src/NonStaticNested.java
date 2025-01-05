class NonStaticOuterClass {
    int instanceVariable = 10;
    static int classVariable = 20;

    class InnerClass {
        public void print() {
            System.out.println("InstanceVariable : " + instanceVariable + " ClassVariable : " + classVariable);
        }
    }
}

public class NonStaticNested {
    // It has access to all the instance variables and methods of outer class.
    public static void main(String[] args) {

        NonStaticOuterClass NonStaticOuterObj = new NonStaticOuterClass();
        NonStaticOuterClass.InnerClass InnerObj = NonStaticOuterObj.new InnerClass();

        InnerObj.print();
    }


}
