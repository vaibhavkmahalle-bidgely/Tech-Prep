package LLD.patterns.creational.singleton.eager;

public class StaticVsInstanceExample {
    
    // Static variable - belongs to the CLASS
    private static int staticCounter = 0;
    
    // Instance variable - belongs to each OBJECT
    private int instanceCounter = 0;
    
    // STATIC METHOD - can be called without creating an object
    public static void staticMethod() {
        staticCounter++;
        System.out.println("Static method called. Static counter: " + staticCounter);
        
        // ❌ CANNOT access instance variables/methods from static method
        // instanceCounter++;  // This would cause a compile error!
    }
    
    // INSTANCE METHOD - needs an object to be called
    public void instanceMethod() {
        instanceCounter++;
        staticCounter++;  // ✅ CAN access static variables from instance method
        System.out.println("Instance method called. Instance counter: " + instanceCounter);
        System.out.println("Static counter: " + staticCounter);
    }
    
    public static void main(String[] args) {
        System.out.println("=== STATIC METHOD ===");
        // ✅ Call static method directly on the CLASS (no object needed)
        StaticVsInstanceExample.staticMethod();
        StaticVsInstanceExample.staticMethod();
        StaticVsInstanceExample.staticMethod();
        
        System.out.println("\n=== INSTANCE METHOD ===");
        // ❌ Cannot call instance method on class
        // StaticVsInstanceExample.instanceMethod(); // Compile error!
        
        // ✅ Must create objects first
        StaticVsInstanceExample obj1 = new StaticVsInstanceExample();
        StaticVsInstanceExample obj2 = new StaticVsInstanceExample();
        
        obj1.instanceMethod();
        obj1.instanceMethod();
        
        obj2.instanceMethod();
        obj2.instanceMethod();
        
        System.out.println("\n=== COMPARISON ===");
        System.out.println("Static counter (shared): " + staticCounter);
        System.out.println("obj1 instance counter: " + obj1.instanceCounter);
        System.out.println("obj2 instance counter: " + obj2.instanceCounter);
    }
}

