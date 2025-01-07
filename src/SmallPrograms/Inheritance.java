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

        Student s1 = new Student();
        s1.setAge(22);
        s1.setName("Vaibhav");
        s1.setRollNo(21);
        System.out.println(s1.getDetails());
        System.out.println(s1.getRollNo());



    }
}
