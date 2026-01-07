package javaconcepts.static_;

public class StaticVsInstanceExample {
    
    // STATIC - belongs to CLASS, called without object
    public static void staticMethod() {
        System.out.println("Static method - called on CLASS");
    }
    
    // INSTANCE - belongs to OBJECT, needs object to call
    public void instanceMethod() {
        System.out.println("Instance method - called on OBJECT");
    }
    
    public static void main(String[] args) {
        // Static: Call directly on class (no object needed)
        StaticVsInstanceExample.staticMethod();
        
        // Instance: Must create object first
        StaticVsInstanceExample obj = new StaticVsInstanceExample();
        obj.instanceMethod();
    }
}

