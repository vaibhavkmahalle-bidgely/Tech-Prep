package classes;

class OuterClass {
    int instanceVariable = 10;
    static int classVariable = 20;

    static class NestedClass {
        public void print() {
            System.out.println(classVariable + ": classVariable " + "and instanceVariable can't access");
            // here we can access classVariable but not instanceVariable bcoz instanceVariable is related to Classes.OuterClass.
            // static class can only access static variables and methods.
        }

        ;
    }
}

class OuterClass1 {
    private static class PrivateNestedClass{
        public void print(){
            System.out.println("This is nested class but with private keyword");
        }
    }

    public void accessPrint(){
        PrivateNestedClass privateNestedObj = new PrivateNestedClass();
        privateNestedObj.print();
    }

}

public class StaticNested {
    // Access specifier for class is package private by default : accessible within the same package, or public.
    // But nested classes can be created as public, private, protected anything.

    // Class within another class is called Nested Class
    // If a Class B is only going to be used by Class A then we can create Class B inside Class A to avoid creating separate class file for the same.
    // This helps in grouping logically similar classes in a single file.

    // Scope is same as Outer class.

    // Two types : Static Nested & Non-Static Nested Class
    // Non-Static : Member Inner, Local Inner, Anonymous Inner
    public static void main(String[] args) {
        // here you didn't need Object of Classes.OuterClass to access the NestedClass that's bcoz it's static.
        OuterClass.NestedClass NestedObj = new OuterClass.NestedClass();
        NestedObj.print();

        OuterClass1 OuterClassObj = new OuterClass1();
        OuterClassObj.accessPrint();
    }
}
