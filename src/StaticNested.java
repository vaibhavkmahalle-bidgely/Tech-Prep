class OuterClass {
    int instanceVariable = 10;
    static int classVariable = 20;

    static class NestedClass {
        public void print() {
            System.out.println(classVariable + ": classVariable " + "and instanceVariable can't access");
            // here we can access classVariable but not instanceVariable bcoz instanceVariable is related to OuterClass.
            // static class can only access static variables and methods.
        }

        ;
    }
}

public class StaticNested {
    // Access specifier for class is package private by default : accessible within the same package, or public.

    // Class within another class is called Nested Class
    // If a Class B is only going to be used by Class A then we can create Class B inside Class A to avoid creating separate class file for the same.
    // This helps in grouping logically similar classes in a single file.

    // Scope is same as Outer class.

    // Two types : Static Nested & Non-Static Nested Class
    // Non-Static : Member Inner, Local Inner, Anonymous Inner
    public static void main(String[] args) {
        OuterClass.NestedClass NestedObj = new OuterClass.NestedClass();
        NestedObj.print();
        // here you didn't need Object of OuterClass to access the NestedClass that's bcoz it's static.
    }
}
