package classes;

public class ObjectClass {
    private String name ;
    private int age ;

    // Constructor
    public ObjectClass(String name, int age){
        this.name = name ;
        this.age = age ;
    }

    // Overriding toString() method from Object class
    @Override
    public String toString(){
        return "Name : "+ name + ", age : "+age+".";
    }

    public static void main(String[] args) {
        ObjectClass obj = new ObjectClass("Vaibhav", 26);

        System.out.println(obj.toString());
    }
}
