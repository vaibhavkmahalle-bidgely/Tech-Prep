# Java Concepts Used in Singleton Pattern

## 📚 Core Java Concepts

The Singleton pattern relies on several fundamental Java concepts. If you need to understand these better, refer to the examples in the `javaconcepts` package.

---

## 1. Static Methods and Variables

**Why it matters for Singleton:**
- `getInstance()` is a **static method** - can be called without creating an object
- `instance` is a **static variable** - shared across all calls

**Example:**
```java
public static Singleton getInstance() {  // static method
    return instance;                      // static variable
}

// Called on the CLASS, not an object:
Singleton obj = Singleton.getInstance();
```

**📖 Learn more:** `src/javaconcepts/static/StaticVsInstanceExample.java`

---

## 2. Access Modifiers (private, public)

**Why it matters for Singleton:**
- **Private constructor** - prevents creating instances with `new`
- **Public getInstance()** - provides controlled access

**Example:**
```java
private Singleton() { }              // private - can't call from outside
public static Singleton getInstance() // public - accessible everywhere
```

---

## 3. Thread Safety (volatile, synchronized)

**Why it matters for Singleton:**
- Multiple threads might try to create instance simultaneously
- Need to ensure only ONE instance is created

**Example:**
```java
private static volatile Singleton instance;  // volatile for thread safety

public static Singleton getInstance() {
    if (instance == null) {
        synchronized (Singleton.class) {     // synchronized block
            if (instance == null) {
                instance = new Singleton();
            }
        }
    }
    return instance;
}
```

**📖 Learn more:** (Thread safety examples - to be added)

---

## 4. Inner Static Classes (Bill Pugh)

**Why it matters for Singleton:**
- JVM guarantees thread-safe initialization of static inner classes
- Provides lazy loading without explicit synchronization

**Example:**
```java
private static class Holder {
    private static final Singleton INSTANCE = new Singleton();
}

public static Singleton getInstance() {
    return Holder.INSTANCE;  // Loaded only when first accessed
}
```

---

## 5. Enums

**Why it matters for Singleton:**
- Enum instances are inherently singleton
- Serialization-safe by default
- Reflection-proof

**Example:**
```java
public enum Singleton {
    INSTANCE;
    
    public void doSomething() { }
}

// Usage:
Singleton.INSTANCE.doSomething();
```

---

## Quick Reference

| Concept | Used In | Purpose |
|---------|---------|---------|
| Static method | `getInstance()` | Access without object |
| Static variable | `instance` | Shared across all calls |
| Private constructor | `Singleton()` | Prevent external instantiation |
| Volatile | Lazy DCL | Thread-safe visibility |
| Synchronized | Lazy DCL | Thread-safe creation |
| Inner static class | Bill Pugh | Lazy + thread-safe |
| Enum | Enum Singleton | Serialization-safe |

---

## 🔗 Related Java Concepts

- **Static vs Instance:** `src/javaconcepts/static/StaticVsInstanceExample.java`
- **Exception Handling:** `src/javaconcepts/exception/`
- **Memory Management:** `src/javaconcepts/memory/`

---

**Note:** Understanding these Java fundamentals is crucial for mastering design patterns!

