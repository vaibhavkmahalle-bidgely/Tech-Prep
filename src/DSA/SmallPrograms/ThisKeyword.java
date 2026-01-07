package SmallPrograms;
class Box1{
    private int l, b , h;
    private String who, are, you;

    public void setDimensions(int x, int y, int z){
        // here calling object for setDimensions is Object b, so this will refer to object b.
        // b.l we cannot use as the object is not initialized while defining methods, so this.l will be pointing to variable l of object b.

        l = x;
        b = y;
        h = z;
    }

    public void setVariables(String who, String are, String you  ){
        this.who = who; // here local variable has more priority so who = who won't make sense both will point to local variable, so this points to the calling object.
        this.are = are;
        this.you = you;


    }

    public void printDetails(){
        System.out.println("Here are my details : "+ this.who+","+this.are+","+this.you);
    }
}

public class ThisKeyword {
    // this :-> It is a local variable in instance member methods referring the Caller Object.
    // this :-> It is a reference variable available for all the instance member methods.
    // this keyword is used as a reference to the current object (calling object) which is an instance of the current class.
    // this reference to the current object is useful in situations where a local variable hides , or shadows, a field with the same name.
    // if a method needs to pass the current object to another method, it can do so using this reference.
    // this reference cannot be used in a static context, as static code is not executed in the context of any object.

    public static void main(String[] args) {
        Box1 b = new Box1();
        b.setDimensions(3,4,5);
        b.setVariables("Vaibhav","Kishor","Mahalle");
        b.printDetails();
    }
}
