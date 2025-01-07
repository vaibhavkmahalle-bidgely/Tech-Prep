package Classes;

public class GenericMethod {
//    public void printArray(String []s){
//        for (int i = 0; i < s.length; i++) {
//            System.out.println(s[i]);
//        }
//    }
//
//    public void printArray(Integer []n){
//        for (int i = 0; i < n.length; i++) {
//            System.out.println(n[i]);
//        }
//    }

    // Type parameters can only represent reference types not primitive types.
    public <T> void printArray(T[] s) {
        // one variation of for loop
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

        // another variation : for array s the value in s is sequentially added to x with each iteration.
        for (T x : s) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        GenericMethod genericObj = new GenericMethod();
        String countries[] = new String[]{"hello", "my", "name", "is", "vaibhav"};
        Integer numbers[] = {1, 2, 3, 4, 5};

        genericObj.printArray(countries);
        genericObj.printArray(numbers);
        // both the methods are exactly the same but different types this is called method overloading of polymorphism.

        // here printArray method is limited by the type and is not generic we need a method which can accommodate any Type without need to rewrite the code.
    }
}
