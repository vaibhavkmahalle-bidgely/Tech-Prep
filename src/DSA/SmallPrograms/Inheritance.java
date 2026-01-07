package SmallPrograms;

class Person {
   private String name;
   private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return " Name and age are " + name +","+ age ;
    }
}

class Student extends Person {
    private int rollNo;

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getRollNo() {
        return "Roll no is : "+rollNo;
    }
}
public class Inheritance {
    public static void main(String[] args) {
        /** In java each class can have maximum one superclass but unlimited subclasses.
         * private members of parent are not accessible by the subclass and can only be indirectly accessed.
         * members that have default accessibility in the superclass are also not accessible by subclass in other package.
         * Single Inheritance , Multilevel Inheritance, Hierarchical Inheritance
         */
        Student s1 = new Student();
        s1.setAge(22);
        s1.setName("Vaibhav");
        s1.setRollNo(21);
        System.out.println(s1.getDetails());
        System.out.println(s1.getRollNo());



    }
}
