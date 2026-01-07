package dsa.smallprograms;

class Box {
    private int length, width, height;
    private boolean bool;

    public void setDimensions(int l, int b, int h) {
        length = l;
        width = b;
        height = h;
        bool = true;
    }

    public void showDimensions() {
        System.out.println("Dimensions of box are : L, B, H : " + length + " , " + width + " , " + height);
        System.out.println("Boolean value is : "+ bool);
    }
}

public class ClassAndObjects {
    // if I want to store the data of different data types but with some relation between them, e.g. Student
    // here the relation between them is established bcoz they belong to same class.

    // Class is a description of object's property and behaviour.
    // creating a class is as good as creating a data type.
    // class is defining category of data.

    // Object is a real world entity
    // Object is an instance of a class
    // Object consumes memory to hold property values.
    // Object is as good as a BIG variable.

    // In java we make objects dynamically only.

    // variable obj is pointing to the object of Class Box
    public static void main(String[] args) {
        Box obj = new Box();
        obj.setDimensions(2, 3, 4);
        obj.showDimensions();

        // here obj will point to new object of Class Box, hence the values assigned to it will be gone.
        obj = new Box();
        obj.showDimensions();
        // default value of instance variable is 0.
    }


}
