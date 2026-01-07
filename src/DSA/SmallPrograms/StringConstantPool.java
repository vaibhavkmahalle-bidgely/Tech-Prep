package SmallPrograms;

public class StringConstantPool {
    public static void main(String[] args) {
        String name3 = new String("Vaibhav");
        String name4 = name3.intern();
        String name1 = "Vaibhav";
        String name2 = "Vaibhav";

        if (name1 == name4) {
            System.out.println("name1 and name4 are equal");
        } else {
            System.out.println("not equal");
        }

        if (name3 == name4) {
            System.out.println("name2 and name4 are equal");
        } else {
            System.out.println("not equal");
        }


    }
}
