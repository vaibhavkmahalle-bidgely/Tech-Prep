package LLD.patterns.creational.singleton;

/**
 * ═══════════════════════════════════════════════════════════════════════════
 *                          SINGLETON PATTERN - QUICK NOTES
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * PURPOSE:
 * --------
 * Ensures a class has ONLY ONE INSTANCE throughout the application lifetime
 * and provides a global point of access to it.
 * 
 * 
 * WHEN TO USE:
 * ------------
 * ✓ Database connections
 * ✓ Configuration/Settings manager
 * ✓ Logger
 * ✓ Cache
 * ✓ Thread pools
 * ✓ File manager
 * ✓ Device drivers
 * 
 * 
 * KEY CHARACTERISTICS:
 * --------------------
 * 1. Private constructor (prevents direct instantiation)
 * 2. Static instance variable
 * 3. Public static getInstance() method
 * 4. Thread-safety considerations
 * 
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 *                          IMPLEMENTATION APPROACHES
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * 
 * 1️⃣  EAGER INITIALIZATION (see: eager/Singleton.java)
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * class Singleton {
 *     private static Singleton instance = new Singleton();  // Created at class loading
 *     
 *     private Singleton() {}  // Private constructor
 *     
 *     public static Singleton getInstance() {
 *         return instance;
 *     }
 * }
 * 
 * PROS:
 * ✓ Simple and clean
 * ✓ Thread-safe by default (JVM guarantees)
 * ✓ No synchronization overhead
 * 
 * CONS:
 * ✗ Instance created even if never used (wastes memory)
 * ✗ No lazy loading
 * ✗ Cannot handle exceptions during creation
 * 
 * USE WHEN: Instance will definitely be used & creation is lightweight
 * 
 * 
 * 2️⃣  LAZY INITIALIZATION (see: lazy/Singleton.java)
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * class Singleton {
 *     private static volatile Singleton instance = null;  // volatile is crucial!
 *     
 *     private Singleton() {}
 *     
 *     public static Singleton getInstance() {
 *         if (instance == null) {                    // First check (no locking)
 *             synchronized (Singleton.class) {       // Lock only if needed
 *                 if (instance == null) {            // Second check (with lock)
 *                     instance = new Singleton();
 *                 }
 *             }
 *         }
 *         return instance;
 *     }
 * }
 * 
 * TECHNIQUE: Double-Checked Locking (DCL)
 * 
 * PROS:
 * ✓ Lazy loading (created only when needed)
 * ✓ Thread-safe
 * ✓ Memory efficient
 * ✓ Minimal synchronization overhead
 * 
 * CONS:
 * ✗ More complex code
 * ✗ Requires 'volatile' keyword (Java 5+)
 * 
 * WHY VOLATILE?
 * - Prevents instruction reordering
 * - Ensures visibility across threads
 * - Without it, another thread might see partially constructed object
 * 
 * WHY DOUBLE-CHECK?
 * - First check: Avoids synchronization overhead after initialization
 * - Second check: Ensures only one instance is created (thread-safety)
 * 
 * USE WHEN: Instance might not be used & creation is expensive
 * 
 * 
 * 3️⃣  BILL PUGH SINGLETON (Best Practice - Recommended!)
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * class Singleton {
 *     private Singleton() {}
 *     
 *     // Inner static helper class
 *     private static class SingletonHelper {
 *         private static final Singleton INSTANCE = new Singleton();
 *     }
 *     
 *     public static Singleton getInstance() {
 *         return SingletonHelper.INSTANCE;
 *     }
 * }
 * 
 * PROS:
 * ✓ Lazy loading (loaded when getInstance() is called)
 * ✓ Thread-safe (JVM guarantees)
 * ✓ No synchronization needed
 * ✓ Simple and elegant
 * 
 * HOW IT WORKS:
 * - Inner class is not loaded until getInstance() is called
 * - JVM guarantees thread-safety during class initialization
 * 
 * USE WHEN: You want best of both worlds (lazy + thread-safe + simple)
 * 
 * 
 * 4️⃣  ENUM SINGLETON (Joshua Bloch's Recommendation)
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * public enum Singleton {
 *     INSTANCE;
 *     
 *     public void doSomething() {
 *         // Your methods here
 *     }
 * }
 * 
 * // Usage:
 * Singleton.INSTANCE.doSomething();
 * 
 * PROS:
 * ✓ Simplest implementation
 * ✓ Thread-safe by default
 * ✓ Serialization safe (prevents multiple instances)
 * ✓ Reflection-proof (cannot create new instance via reflection)
 * 
 * CONS:
 * ✗ No lazy loading
 * ✗ Cannot extend a class (enums can't extend)
 * 
 * USE WHEN: You want bulletproof singleton with serialization
 * 
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 *                          COMMON PITFALLS & SOLUTIONS
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * 
 * ⚠️  PROBLEM 1: Breaking Singleton with Reflection
 * ───────────────────────────────────────────────────────────────────────────
 * 
 * Constructor<?> constructor = Singleton.class.getDeclaredConstructor();
 * constructor.setAccessible(true);
 * Singleton instance2 = (Singleton) constructor.newInstance();  // New instance!
 * 
 * SOLUTION: Throw exception in constructor if instance already exists
 * 
 * private Singleton() {
 *     if (instance != null) {
 *         throw new IllegalStateException("Instance already created!");
 *     }
 * }
 * 
 * 
 * ⚠️  PROBLEM 2: Breaking Singleton with Serialization
 * ───────────────────────────────────────────────────────────────────────────
 * 
 * When deserializing, Java creates a new instance!
 * 
 * SOLUTION: Implement readResolve() method
 * 
 * protected Object readResolve() {
 *     return getInstance();  // Return existing instance
 * }
 * 
 * 
 * ⚠️  PROBLEM 3: Breaking Singleton with Cloning
 * ───────────────────────────────────────────────────────────────────────────
 * 
 * SOLUTION: Override clone() and throw exception
 * 
 * @Override
 * protected Object clone() throws CloneNotSupportedException {
 *     throw new CloneNotSupportedException("Singleton cannot be cloned");
 * }
 * 
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 *                          REAL-WORLD EXAMPLES IN JAVA
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * 1. Runtime.getRuntime()
 *    - JVM runtime environment
 * 
 * 2. Desktop.getDesktop()
 *    - Desktop integration
 * 
 * 3. Spring Framework
 *    - Beans are singleton by default
 * 
 * 4. Logger instances
 *    - Log4j, SLF4J loggers
 * 
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 *                          COMPARISON TABLE
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * Approach          | Lazy | Thread-Safe | Simple | Serialization-Safe
 * ──────────────────|------|-------------|--------|───────────────────
 * Eager             |  ✗   |     ✓       |   ✓    |        ✗
 * Lazy (DCL)        |  ✓   |     ✓       |   ✗    |        ✗
 * Bill Pugh         |  ✓   |     ✓       |   ✓    |        ✗
 * Enum              |  ✗   |     ✓       |   ✓    |        ✓
 * 
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 *                          INTERVIEW QUESTIONS
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * Q1: Why is Singleton constructor private?
 * A: To prevent direct instantiation from outside the class.
 * 
 * Q2: What is double-checked locking?
 * A: Optimization technique that checks instance twice - once without lock
 *    (for performance) and once with lock (for thread-safety).
 * 
 * Q3: Why use volatile keyword?
 * A: Prevents instruction reordering and ensures visibility across threads.
 *    Without it, threads might see partially constructed objects.
 * 
 * Q4: Can we serialize a Singleton?
 * A: Yes, but need to implement readResolve() to prevent new instance creation.
 * 
 * Q5: Which is the best Singleton implementation?
 * A: Enum (for serialization safety) or Bill Pugh (for general use).
 * 
 * Q6: Is Singleton thread-safe?
 * A: Depends on implementation. Eager and Enum are always thread-safe.
 *    Lazy needs proper synchronization (DCL or Bill Pugh).
 * 
 * Q7: What are disadvantages of Singleton?
 * A: - Hard to test (global state)
 *    - Violates Single Responsibility Principle
 *    - Hidden dependencies
 *    - Difficult to subclass
 *    - Can cause tight coupling
 * 
 * Q8: How to make Singleton reflection-proof?
 * A: Use Enum or throw exception in constructor if instance exists.
 * 
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 *                          QUICK REVISION CHECKLIST
 * ═══════════════════════════════════════════════════════════════════════════
 * 
 * □ Understand: One instance per JVM
 * □ Remember: Private constructor
 * □ Know: Eager vs Lazy initialization
 * □ Understand: Double-checked locking
 * □ Remember: volatile keyword importance
 * □ Know: Bill Pugh approach (best practice)
 * □ Know: Enum approach (serialization-safe)
 * □ Understand: Breaking scenarios (reflection, serialization, cloning)
 * □ Remember: Real-world examples (Runtime, Spring beans)
 * 
 * ═══════════════════════════════════════════════════════════════════════════
 */

public class NOTES {
    // This file is for documentation purposes only
    // See actual implementations in:
    // - eager/Singleton.java (Eager Initialization)
    // - lazy/Singleton.java (Lazy Initialization with DCL)
}

