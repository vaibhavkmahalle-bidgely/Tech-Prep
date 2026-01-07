# Singleton Pattern - Quick Reference Guide

## 🎯 One-Line Summary
**Ensures a class has only ONE instance and provides global access to it.**

---

## 📊 Quick Comparison Table

| Approach | Lazy? | Thread-Safe? | Complexity | Use Case |
|----------|-------|--------------|------------|----------|
| **Eager** | ❌ | ✅ | Low | Lightweight, always used |
| **Lazy (DCL)** | ✅ | ✅ | High | Expensive, might not be used |
| **Bill Pugh** | ✅ | ✅ | Medium | Best general-purpose |
| **Enum** | ❌ | ✅ | Low | Serialization-safe |
| **Spring Bean** | Configurable | ✅ | Low | Modern apps with DI |

---

## 💡 When to Use - Decision Tree

```
Do you need exactly ONE instance?
│
├─ YES → Continue
│
└─ NO → Don't use Singleton!

Is the instance expensive to create?
│
├─ YES → Use Lazy (DCL or Bill Pugh)
│
└─ NO → Use Eager or Enum

Do you need serialization safety?
│
├─ YES → Use Enum
│
└─ NO → Use Bill Pugh (best practice)

Are you using Spring Framework?
│
├─ YES → Use @Component/@Service (Spring-managed)
│
└─ NO → Use Bill Pugh or Enum
```

---

## 🔍 Real-World Examples from HER Service

### 1. AWS CloudWatch Metrics Publisher
**Why Singleton?**
- Expensive AWS client creation
- Used throughout the application
- Need consistent connection

**Code Location**: `AwsMetricPublisher.java`

```java
// Usage everywhere in HER service:
IMetricPublisher metricPublisher = MetricPublisherFactory.getInstance(AwsMetricPublisher.class);
metricPublisher.publishMetrics("HER", "PDFGenerated", new Date(), 1.0, dimensions);
```

---

### 2. Spring Application Context
**Why Singleton?**
- Only ONE Spring container per application
- Global access to beans
- Thread-safe by design

**Code Location**: `BidgelySpringAppContext.java`

```java
// Get beans from anywhere:
JedisLockProvider lockProvider = BidgelySpringAppContext.getBean(JedisLockProvider.class);
```

---

### 3. Spring Service Beans (HER Services)
**Why Singleton?**
- Stateless services
- Dependency injection
- Performance (no repeated creation)

**Code Location**: `HerQueryProcessingService.java`, `HERLayoutLoader.java`

```java
@Service("herQueryProcessingService")
public class HerQueryProcessingService {
    // Spring creates ONE instance
    // Injects it wherever needed
}
```

---

## 🚀 Implementation Cheat Sheet

### Eager Initialization
```java
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() { return INSTANCE; }
}
```
**Pros**: Simple, thread-safe  
**Cons**: Created even if not used

---

### Lazy with Double-Checked Locking
```java
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```
**Pros**: Lazy, thread-safe  
**Cons**: Complex, requires `volatile`

---

### Bill Pugh (Recommended)
```java
public class Singleton {
    private Singleton() {}
    
    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }
    
    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
```
**Pros**: Lazy, thread-safe, simple  
**Cons**: None (best practice!)

---

### Enum (Serialization-Safe)
```java
public enum Singleton {
    INSTANCE;
    
    public void doSomething() {
        // methods here
    }
}

// Usage:
Singleton.INSTANCE.doSomething();
```
**Pros**: Simplest, serialization-safe, reflection-proof  
**Cons**: No lazy loading, can't extend classes

---

### Spring Bean (Modern Approach)
```java
@Component
public class MySingleton {
    // Spring manages lifecycle
}

// Or in XML:
<bean id="mySingleton" class="com.example.MySingleton" scope="singleton"/>
```
**Pros**: Framework-managed, testable, DI support  
**Cons**: Requires Spring framework

---

## ⚠️ Common Pitfalls

### 1. Not Thread-Safe
```java
// ❌ WRONG - Not thread-safe!
public class Singleton {
    private static Singleton instance;
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();  // Race condition!
        }
        return instance;
    }
}
```

### 2. Forgetting `volatile`
```java
// ❌ WRONG - Missing volatile!
private static Singleton instance;  // Should be volatile!
```

### 3. Breaking with Reflection
```java
// ❌ Can break singleton!
Constructor<?> constructor = Singleton.class.getDeclaredConstructor();
constructor.setAccessible(true);
Singleton instance2 = (Singleton) constructor.newInstance();
```

**Solution**: Use Enum or throw exception in constructor

---

## 🧪 Testing Singletons

### Problem: Hard to Test
```java
// Hard to mock:
public class MyService {
    public void doWork() {
        Singleton.getInstance().doSomething();  // Tightly coupled!
    }
}
```

### Solution 1: Dependency Injection
```java
public class MyService {
    private final Singleton singleton;
    
    public MyService(Singleton singleton) {
        this.singleton = singleton;  // Can inject mock!
    }
}
```

### Solution 2: Setter for Testing
```java
public class MetricPublisherFactory {
    public static IMetricPublisher metricPublisher = null;
    
    // For testing
    public static void setInstance(IMetricPublisher publisher) {
        metricPublisher = publisher;
    }
}

// In test:
@BeforeEach
void setUp() {
    MetricPublisherFactory.setInstance(new FakeMetricPublisher());
}
```

---

## 📝 Interview Questions & Answers

**Q1: Why is constructor private?**  
A: To prevent creating multiple instances via `new Singleton()`

**Q2: What is double-checked locking?**  
A: Check instance twice - once without lock (fast path), once with lock (thread-safety)

**Q3: Why use `volatile`?**  
A: Prevents instruction reordering, ensures visibility across threads

**Q4: Can Singleton be serialized?**  
A: Yes, but implement `readResolve()` to prevent new instance on deserialization

**Q5: Best Singleton implementation?**  
A: Bill Pugh for general use, Enum for serialization safety, Spring beans for modern apps

**Q6: Is Singleton an anti-pattern?**  
A: Can be if overused. Issues: global state, hard to test, hidden dependencies

**Q7: How to make reflection-proof?**  
A: Use Enum or throw exception in constructor if instance exists

**Q8: Singleton vs Static class?**  
A: Singleton can implement interfaces, be passed as parameter, lazy-loaded. Static can't.

---

## 🎓 Study Path

### Step 1: Understand Theory
- [x] Read `NOTES.java` in this folder
- [ ] Understand WHY singleton is needed
- [ ] Learn different implementations

### Step 2: Practice
- [ ] Run `eager/SingletonExample.java`
- [ ] Run `lazy/Singleton.java`
- [ ] Implement Bill Pugh yourself
- [ ] Implement Enum singleton

### Step 3: Real-World Study
- [ ] Study `AwsMetricPublisher.java` in pingpong
- [ ] Trace how `MetricPublisherFactory` is used
- [ ] Find all `@Component` and `@Service` in HER service
- [ ] Understand Spring singleton scope

### Step 4: Apply
- [ ] Identify where singleton is appropriate in your code
- [ ] Refactor if needed
- [ ] Write tests for singleton classes

---

## 🔗 Related Patterns

1. **Factory Pattern** (Next to study!)
   - Often used WITH singleton
   - Example: `MetricPublisherFactory`

2. **Dependency Injection**
   - Modern alternative to singleton
   - Example: Spring beans

3. **Object Pool**
   - Similar concept but multiple instances
   - Example: Database connection pools

---

## 📚 Resources

### In Your Codebase
- `src/LLD/patterns/creational/singleton/NOTES.java` - Theory
- `src/LLD/patterns/creational/singleton/HER_SERVICE_SINGLETON_EXAMPLES.md` - Real examples
- `pingpong/core/utils/.../AwsMetricPublisher.java` - Production code

### External
- "Effective Java" by Joshua Bloch (Item 3: Enforce singleton with enum)
- Gang of Four Design Patterns book
- Spring Framework documentation on bean scopes

---

## ✅ Checklist Before Moving to Next Pattern

- [ ] Can explain WHY singleton is needed
- [ ] Know 4 implementation approaches
- [ ] Understand thread-safety issues
- [ ] Can identify singleton in HER service
- [ ] Know when NOT to use singleton
- [ ] Understand Spring singleton scope
- [ ] Can write testable singleton code

---

**Next Pattern**: Factory Pattern (heavily used in HER service for creating different types of publishers, validators, and data providers!)

