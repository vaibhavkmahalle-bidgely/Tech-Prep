# Singleton Pattern - Complete Learning Guide

## 📖 Overview

This folder contains everything you need to master the Singleton design pattern, from theory to real-world application in the HER (Home Energy Report) paper generation service.

---

## 📂 Folder Structure

```
singleton/
├── README.md                           ← You are here
├── NOTES.java                          ← Comprehensive theory & notes
├── QUICK_REFERENCE.md                  ← Quick lookup guide
├── HER_SERVICE_SINGLETON_EXAMPLES.md   ← Real-world examples from HER service
├── EXERCISES.md                        ← Hands-on practice exercises
│
├── eager/
│   ├── Singleton.java                  ← Eager initialization implementation
│   └── SingletonExample.java           ← Usage example
│
├── lazy/
│   └── Singleton.java                  ← Lazy initialization with DCL
│
└── solutions/                          ← Exercise solutions (create as you solve)
    ├── Exercise1_BillPugh.java
    ├── Exercise2_Enum.java
    └── ...
```

---

## 🎯 Learning Path

### Phase 1: Understand the Theory (30 minutes)
1. **Read**: `NOTES.java` - Complete theory with all implementation approaches
2. **Understand**: Why singleton was needed, what problems it solves
3. **Review**: `QUICK_REFERENCE.md` for quick lookup

### Phase 2: Study Implementations (30 minutes)
1. **Run**: `eager/SingletonExample.java` - See eager initialization in action
2. **Study**: `lazy/Singleton.java` - Understand double-checked locking
3. **Compare**: Different approaches and their trade-offs

### Phase 3: Real-World Application (1 hour)
1. **Read**: `HER_SERVICE_SINGLETON_EXAMPLES.md`
2. **Explore**: Real singleton usage in HER service:
   - `AwsMetricPublisher` - Classic singleton for AWS client
   - `MetricPublisherFactory` - Factory + Singleton pattern
   - `BidgelySpringAppContext` - Spring context singleton
   - Spring beans - Framework-managed singletons
3. **Trace**: How metrics are published in PDF generation

### Phase 4: Hands-On Practice (2-3 hours)
1. **Complete**: Exercises in `EXERCISES.md`
2. **Implement**: All 4 singleton approaches yourself
3. **Test**: Thread-safety and reflection scenarios
4. **Challenge**: Build a mini HER service scenario

### Phase 5: Deep Dive (Optional, 1-2 hours)
1. **Study**: Actual HER service code in `pingpong/` repository
2. **Find**: All singleton instances in the codebase
3. **Analyze**: Why each singleton was chosen
4. **Refactor**: Identify potential improvements

---

## 🔑 Key Concepts

### What is Singleton?
A design pattern that ensures a class has **only ONE instance** throughout the application and provides a **global access point** to it.

### Why Use It?
- ✅ Control access to shared resources (DB connections, AWS clients)
- ✅ Reduce memory footprint (one instance vs many)
- ✅ Provide global access point (configuration, logging)
- ✅ Ensure consistency (same state everywhere)

### When NOT to Use It?
- ❌ When you need multiple instances
- ❌ When testing is critical (hard to mock)
- ❌ When state varies per user/request
- ❌ When it creates tight coupling

---

## 🎨 Implementation Approaches

### 1. Eager Initialization
```java
private static final Singleton INSTANCE = new Singleton();
```
**Use when**: Instance will definitely be used, creation is cheap

### 2. Lazy with Double-Checked Locking
```java
private static volatile Singleton instance;
// ... double-checked locking in getInstance()
```
**Use when**: Instance might not be used, creation is expensive

### 3. Bill Pugh (Inner Static Class)
```java
private static class Holder {
    private static final Singleton INSTANCE = new Singleton();
}
```
**Use when**: Best general-purpose approach (recommended!)

### 4. Enum
```java
public enum Singleton { INSTANCE; }
```
**Use when**: Need serialization safety, reflection-proof

### 5. Spring Bean
```java
@Component / @Service
```
**Use when**: Using Spring framework (modern approach)

---

## 💡 Real-World Examples from HER Service

### Example 1: AWS CloudWatch Metrics
**File**: `core/utils/src/main/java/com/bidgely/cloud/cloudwatch/AwsMetricPublisher.java`

**Why Singleton?**
- AWS client is expensive to create
- Metrics published from everywhere in the app
- Need consistent connection to CloudWatch

**Usage**:
```java
IMetricPublisher publisher = MetricPublisherFactory.getInstance(AwsMetricPublisher.class);
publisher.publishMetrics("HER", "PDFGenerated", new Date(), 1.0, dimensions);
```

### Example 2: Spring Application Context
**File**: `core/utils/src/main/java/com/bidgely/cloud/spring/BidgelySpringAppContext.java`

**Why Singleton?**
- Only ONE Spring container per application
- Global access to beans from non-Spring code
- Thread-safe by design

**Usage**:
```java
JedisLockProvider lockProvider = BidgelySpringAppContext.getBean(JedisLockProvider.class);
```

### Example 3: HER Service Components
**Files**: `HERLayoutLoader.java`, `HerQueryProcessingService.java`

**Why Singleton?**
- Stateless services
- Spring manages lifecycle
- Performance optimization

**Usage**:
```java
@Component("herLayoutLoader")
public class HERLayoutLoader {
    // Spring creates ONE instance
}
```

---

## 🧪 Testing Singletons

### Challenge
Singletons are hard to test because:
- Global state persists between tests
- Hard to mock
- Creates hidden dependencies

### Solutions

#### 1. Provide Setter for Testing
```java
public class MetricPublisherFactory {
    public static void setInstance(IMetricPublisher publisher) {
        metricPublisher = publisher;
    }
}

// In test:
MetricPublisherFactory.setInstance(new FakeMetricPublisher());
```

#### 2. Use Dependency Injection
```java
// Instead of:
Singleton.getInstance().doWork();

// Use:
public class MyClass {
    private final Singleton singleton;
    
    public MyClass(Singleton singleton) {
        this.singleton = singleton;  // Can inject mock!
    }
}
```

#### 3. Use Spring (Best Approach)
```java
@Service
public class MyService {
    @Autowired
    private MetricPublisher publisher;  // Spring injects, easy to mock
}
```

---

## 📊 Comparison Table

| Approach | Lazy? | Thread-Safe? | Complexity | Testability | Use Case |
|----------|-------|--------------|------------|-------------|----------|
| Eager | ❌ | ✅ | Low | Medium | Always used, cheap |
| Lazy (DCL) | ✅ | ✅ | High | Medium | Expensive, conditional |
| Bill Pugh | ✅ | ✅ | Medium | Medium | General purpose |
| Enum | ❌ | ✅ | Low | Low | Serialization-safe |
| Spring Bean | ✅ | ✅ | Low | High | Modern apps |

---

## 🚀 Quick Start

### 1. Run Your First Singleton
```bash
cd src/LLD/patterns/creational/singleton/eager
javac Singleton.java SingletonExample.java
java LLD.patterns.creational.singleton.eager.SingletonExample
```

### 2. Study Real Example
Open: `pingpong/core/utils/src/main/java/com/bidgely/cloud/cloudwatch/AwsMetricPublisher.java`

### 3. Complete First Exercise
Open: `EXERCISES.md` → Exercise 1: Implement Bill Pugh Singleton

---

## 📚 Resources

### In This Folder
- **NOTES.java** - Complete theory, all approaches, interview questions
- **QUICK_REFERENCE.md** - Quick lookup, decision trees, cheat sheets
- **HER_SERVICE_SINGLETON_EXAMPLES.md** - Real-world usage in HER service
- **EXERCISES.md** - 7 hands-on exercises + challenge

### In Pingpong Repository
- `core/utils/src/main/java/com/bidgely/cloud/cloudwatch/AwsMetricPublisher.java`
- `core/utils/src/main/java/com/bidgely/cloud/cloudwatch/MetricPublisherFactory.java`
- `core/utils/src/main/java/com/bidgely/cloud/spring/BidgelySpringAppContext.java`
- `pdf-generation/src/main/java/com/bidgely/cloud/pdf/generation/daemon/PDFGenerator.java`

### External
- "Effective Java" by Joshua Bloch (Item 3)
- Gang of Four Design Patterns
- Spring Framework Documentation

---

## ✅ Mastery Checklist

### Theory
- [ ] Understand why singleton is needed
- [ ] Know 4+ implementation approaches
- [ ] Understand thread-safety issues
- [ ] Know when to use vs when NOT to use

### Implementation
- [ ] Can implement eager initialization
- [ ] Can implement lazy with DCL
- [ ] Can implement Bill Pugh
- [ ] Can implement enum singleton
- [ ] Can make reflection-proof
- [ ] Can make serialization-safe

### Real-World
- [ ] Identified singletons in HER service
- [ ] Understand why each was chosen
- [ ] Can trace metric publishing flow
- [ ] Understand Spring singleton scope

### Practice
- [ ] Completed all exercises
- [ ] Built mini HER service scenario
- [ ] Can write testable singleton code
- [ ] Can identify anti-patterns

---

## 🎯 Next Steps

After mastering Singleton, move to:

### 1. Factory Pattern
- Heavily used in HER service
- Examples: `MetricPublisherFactory`, `SQSFactory`, `LauncherFactory`
- Often combined with Singleton

### 2. Builder Pattern
- Used for complex object creation
- Examples: PDF configuration, HER layout building

### 3. Prototype Pattern
- Cloning objects
- Less common but important to know

---

## 💬 Common Questions

**Q: Is Singleton an anti-pattern?**  
A: It can be if overused. Use judiciously for truly global resources.

**Q: Should I use Singleton or Static class?**  
A: Singleton is more flexible (can implement interfaces, be passed as parameter, lazy-loaded).

**Q: Which implementation should I use?**  
A: Bill Pugh for general use, Enum for serialization safety, Spring beans for modern apps.

**Q: How to test Singleton?**  
A: Provide setter for test doubles, use dependency injection, or use Spring.

---

## 🎓 Study Tips

1. **Don't just read** - Run the code, modify it, break it, fix it
2. **Trace real code** - Follow how metrics flow in HER service
3. **Complete exercises** - Theory without practice is useless
4. **Ask "why"** - Why is this a singleton? Could it be something else?
5. **Compare approaches** - When would you use each?

---

## 📞 Need Help?

- Review `QUICK_REFERENCE.md` for quick answers
- Check `NOTES.java` for detailed explanations
- Study `HER_SERVICE_SINGLETON_EXAMPLES.md` for real-world context
- Complete `EXERCISES.md` for hands-on practice

---

**Remember**: Singleton is just the beginning! Master it, then move to Factory, Builder, and other patterns. Each pattern solves specific problems - learn when to use each! 🚀

---

**Last Updated**: 2024-12-04  
**Next Pattern**: Factory Pattern (see `../factory/` folder)

