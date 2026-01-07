# Singleton Pattern in HER Service (Paper Generation)

## 📚 Table of Contents
1. [Why Singleton Pattern Was Needed](#why-singleton-pattern-was-needed)
2. [Problems It Solves](#problems-it-solves)
3. [Real Examples from HER Service](#real-examples-from-her-service)
4. [How to Use Each Pattern](#how-to-use-each-pattern)
5. [When to Use vs When NOT to Use](#when-to-use-vs-when-not-to-use)

---

## 🎯 Why Singleton Pattern Was Needed

### Historical Context
Before Singleton pattern, developers faced these issues:
- **Resource Wastage**: Creating multiple database connections, thread pools, or configuration objects
- **Inconsistent State**: Different parts of the application having different configuration values
- **Performance Issues**: Expensive object creation happening repeatedly
- **Memory Leaks**: Multiple instances of heavy objects consuming memory

### The Solution
Singleton ensures **ONE and ONLY ONE** instance exists throughout the application lifecycle.

---

## 🔧 Problems It Solves

### 1. **Resource Management**
- **Problem**: Creating multiple CloudWatch metric publishers wastes AWS API calls
- **Solution**: Single instance shared across the application

### 2. **Global Access Point**
- **Problem**: Passing configuration objects through every method call
- **Solution**: Global access via `getInstance()`

### 3. **Consistency**
- **Problem**: Different parts of code using different Spring contexts
- **Solution**: Single ApplicationContext instance

### 4. **Performance**
- **Problem**: Expensive initialization (DB connections, AWS clients) happening multiple times
- **Solution**: Initialize once, reuse everywhere

---

## 💼 Real Examples from HER Service

### Example 1: `AwsMetricPublisher` - Classic Singleton
**Location**: `core/utils/src/main/java/com/bidgely/cloud/cloudwatch/AwsMetricPublisher.java`

**Why it's a Singleton**:
- CloudWatch client is expensive to create
- Metrics need to be published from everywhere in the application
- Should maintain consistent AWS connection

**Implementation**:
```java
public class AwsMetricPublisher implements IMetricPublisher {
    
    // Static instance - shared across entire application
    private static AwsMetricPublisher awsMetricPublisher;
    
    // Constructor sets the static instance
    public AwsMetricPublisher(ICredential credential, IConfig awsConfig, 
                              String environment, boolean cloudwatchMetricsEnabled, 
                              ICacheProvider cacheProvider, long cacheTimespanInSec) {
        this.environment = environment;
        awsClient = AmazonCloudWatchClientBuilder.standard()
            .withRegion(awsConfig.getRegion())
            .withCredentials(credential.getCredentials())
            .build();
        // ... other initialization
        awsMetricPublisher = this;  // Set singleton instance
    }
    
    // Global access point
    public static AwsMetricPublisher getInstance() {
        return awsMetricPublisher;
    }
}
```

**Usage in HER Service**:
```java
// In PDFGenerator.java
IMetricPublisher metricPublisher = MetricPublisherFactory.getInstance(AwsMetricPublisher.class);

// In RedisJobStore.java
private IMetricPublisher metricPublisher = MetricPublisherFactory.getInstance(AwsMetricPublisher.class);
```

**Why This Design?**:
- ✅ Avoids creating multiple AWS CloudWatch clients
- ✅ Reduces API calls and connection overhead
- ✅ Consistent metrics across all services
- ✅ Easy to mock in tests (via `FakeMetricPublisher`)

---

### Example 2: `MetricPublisherFactory` - Factory with Singleton
**Location**: `core/utils/src/main/java/com/bidgely/cloud/cloudwatch/MetricPublisherFactory.java`

**Implementation**:
```java
public class MetricPublisherFactory {
    
    // Static instance - shared globally
    public static IMetricPublisher metricPublisher = null;
    
    // Factory method with lazy initialization
    public static IMetricPublisher getInstance(Class<?> clazz) {
        if (metricPublisher == null) {
            if (clazz.getSimpleName().equals(AwsMetricPublisher.class.getSimpleName())) {
                metricPublisher = AwsMetricPublisher.getInstance();
            }
        }
        return metricPublisher;
    }
    
    // For testing - allows setting mock instance
    public static void setInstance(IMetricPublisher metricPublisher) {
        MetricPublisherFactory.metricPublisher = metricPublisher;
    }
}
```

**Pattern Type**: **Lazy Initialization** (but NOT thread-safe!)

**Why This Design?**:
- ✅ Lazy loading - created only when first requested
- ✅ Testable - can inject `FakeMetricPublisher` for tests
- ⚠️ NOT thread-safe - relies on Spring initialization order

**Usage in Tests**:
```java
@BeforeEach
public void setUp() {
    // Inject fake publisher for testing
    MetricPublisherFactory.setInstance(new FakeMetricPublisher());
}
```

---

### Example 3: `BidgelySpringAppContext` - Spring Context Singleton
**Location**: `core/utils/src/main/java/com/bidgely/cloud/spring/BidgelySpringAppContext.java`

**Implementation**:
```java
public class BidgelySpringAppContext implements ApplicationContextAware {
    
    // Static Spring context - ONE per application
    private static ApplicationContext springAppContext;
    
    // Static method to get beans
    public static <T> T getBean(Class<T> beanClazz) {
        if (springAppContext != null) {
            try {
                return springAppContext.getBean(beanClazz);
            } catch (final NoSuchBeanDefinitionException e) {
                logger.info("NoSuchBeanDefinitionException occurred for class: {}", 
                           beanClazz.toString(), e);
                return null;
            }
        }
        return null;
    }
    
    // Spring calls this to set the context
    @Override
    public void setApplicationContext(ApplicationContext ApplicationContext) {
        springAppContext = ApplicationContext;
    }
}
```

**Why This Design?**:
- ✅ Spring manages the singleton lifecycle
- ✅ Global access to Spring beans from non-Spring code
- ✅ Thread-safe (Spring guarantees this)
- ✅ Allows accessing beans without dependency injection

**Usage in HER Service**:
```java
// Get Spring beans from anywhere
JedisLockProvider lockProvider = BidgelySpringAppContext.getBean(JedisLockProvider.class);
```

---

### Example 4: Spring Singleton Beans (Default Scope)
**Location**: HER service components

**Spring's Singleton Pattern**:
```java
@Component("herLayoutLoader")
public class HERLayoutLoader {
    // Spring creates ONE instance of this class
    // and reuses it everywhere
}

@Service("herQueryProcessingService")
public class HerQueryProcessingService {
    // Spring creates ONE instance
    // Injected wherever needed
}
```

**Why Spring Uses Singleton by Default?**:
- ✅ Performance - no repeated object creation
- ✅ Stateless services can be safely shared
- ✅ Dependency injection works seamlessly
- ✅ Thread-safe when designed properly

**Configuration**:
```xml
<!-- In her-automation.xml -->
<bean id="herQueryProcessingService" 
      class="com.bidgely.cloud.her.automation.service.HerQueryProcessingService">
    <!-- Spring creates ONE instance and injects dependencies -->
</bean>
```

---

## 📖 How to Use Each Pattern

### Pattern 1: Eager Initialization (Your Learning Example)
```java
public class Singleton {
    // Created at class loading time
    private static Singleton instance = new Singleton();
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        return instance;
    }
}
```

**When to Use**: 
- Instance will DEFINITELY be used
- Creation is lightweight
- No complex initialization logic

**Example**: Configuration constants, utility classes

---

### Pattern 2: Lazy Initialization with Double-Checked Locking
```java
public class Singleton {
    private static volatile Singleton instance = null;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {                    // First check
            synchronized (Singleton.class) {       // Lock
                if (instance == null) {            // Second check
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

**When to Use**:
- Instance might NOT be used
- Creation is expensive (DB connections, AWS clients)
- Need thread-safety

**Example**: Database connection pools, AWS clients

---

### Pattern 3: Bill Pugh Singleton (Best Practice)
```java
public class Singleton {
    private Singleton() {}
    
    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }
    
    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
```

**When to Use**:
- Want lazy loading + thread-safety + simplicity
- Modern Java applications
- No special initialization logic needed

**Example**: Loggers, cache managers

---

### Pattern 4: Enum Singleton (Joshua Bloch's Recommendation)
```java
public enum Singleton {
    INSTANCE;
    
    public void doSomething() {
        // Your methods
    }
}

// Usage:
Singleton.INSTANCE.doSomething();
```

**When to Use**:
- Need serialization safety
- Want reflection-proof singleton
- Simple use cases

**Example**: Configuration enums, state machines

---

## ⚖️ When to Use vs When NOT to Use

### ✅ Use Singleton When:

1. **Expensive Resource Management**
   - Database connections
   - AWS clients (CloudWatch, S3, SQS)
   - Thread pools
   - Cache instances

2. **Global Configuration**
   - Application settings
   - Feature flags
   - Environment variables

3. **Logging & Monitoring**
   - Metric publishers
   - Logger instances
   - Audit trail managers

4. **Stateless Services** (Spring beans)
   - Data processors
   - Validators
   - Utility services

### ❌ DON'T Use Singleton When:

1. **Stateful Objects**
   - User sessions
   - Request-specific data
   - Shopping carts

2. **Testing is Critical**
   - Hard to mock
   - Creates hidden dependencies
   - Makes tests interdependent

3. **Need Multiple Instances**
   - Different configurations per tenant
   - Per-user settings
   - Parallel processing with isolation

4. **Violates Single Responsibility**
   - Class doing too much
   - Managing its own lifecycle + business logic

---

## 🎓 Key Takeaways for HER Service

1. **`AwsMetricPublisher`**: Classic singleton for expensive AWS client
2. **`MetricPublisherFactory`**: Factory pattern + singleton for flexibility
3. **`BidgelySpringAppContext`**: Bridge between Spring and non-Spring code
4. **Spring Beans**: Framework-managed singletons (preferred in modern apps)

### Best Practices in HER Service:
- ✅ Use Spring's `@Component`, `@Service` for business logic (framework-managed)
- ✅ Use classic singleton for AWS clients and expensive resources
- ✅ Use factory pattern when you need flexibility (testing, multiple implementations)
- ✅ Always provide a way to inject test doubles (`setInstance()` method)

---

## 🔗 Related Files to Study

1. **Your Learning Examples**:
   - `src/LLD/patterns/creational/singleton/NOTES.java`
   - `src/LLD/patterns/creational/singleton/eager/Singleton.java`
   - `src/LLD/patterns/creational/singleton/lazy/Singleton.java`

2. **Real HER Service Examples**:
   - `core/utils/src/main/java/com/bidgely/cloud/cloudwatch/AwsMetricPublisher.java`
   - `core/utils/src/main/java/com/bidgely/cloud/cloudwatch/MetricPublisherFactory.java`
   - `core/utils/src/main/java/com/bidgely/cloud/spring/BidgelySpringAppContext.java`
   - `pdf-generation/src/main/java/com/bidgely/cloud/pdf/generation/daemon/PDFGenerator.java`

---

**Next Steps**: 
1. Study the code examples above
2. Run the examples in your `eager/` and `lazy/` folders
3. Trace how `MetricPublisherFactory` is used in PDF generation
4. Move to next creational pattern: **Factory Pattern** (heavily used in HER service!)

