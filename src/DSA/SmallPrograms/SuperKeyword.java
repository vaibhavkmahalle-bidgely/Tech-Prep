package dsa.smallprograms;

class AA {
    int x = 10;

    public void f1() {
        System.out.println("You're in class AA");
    }
}

class BB extends AA {
    int x = 10;

    @Override
    public void f1() {
        // using the f1 method of superclass AA.
        System.out.println("You're in class BB");
        super.f1();
    }

    public void f2() {
        int x;
        x = 3;
        this.x = 4;
        super.x = 5;

        System.out.println("variables with local, this , super : "+x+","+this.x+","+super.x);
    }
}

public class SuperKeyword {
    // if your method overrides one of it's superclass's methods, you can invoke the superclass version of the method through the use of the keyword super.
    // It avoids name conflict between member variables of super class and sub class.
    public static void main(String[] args) {
        BB obj = new BB();
        obj.f1();
        obj.f2();
    }

}
