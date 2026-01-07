# Singleton Pattern - Hands-On Exercises

## 🎯 Learning Objectives
By completing these exercises, you will:
1. Implement all 4 types of singleton patterns
2. Understand thread-safety issues
3. Learn to test singleton classes
4. Apply singleton pattern to real-world scenarios

---

## 📝 Exercise 1: Implement Bill Pugh Singleton

### Task
Create a `ConfigurationManager` class using Bill Pugh singleton pattern.

### Requirements
- Private constructor
- Inner static helper class
- `getInstance()` method
- Store application properties (Map<String, String>)
- Methods: `getProperty(String key)`, `setProperty(String key, String value)`

### Template
```java
package LLD.patterns.creational.singleton.billpugh;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    
    private Map<String, String> properties;
    
    // TODO: Implement private constructor
    
    // TODO: Implement inner static helper class
    
    // TODO: Implement getInstance() method
    
    public String getProperty(String key) {
        return properties.get(key);
    }
    
    public void setProperty(String key, String value) {
        properties.put(key, value);
    }
}
```

### Test Your Implementation
```java
public class ConfigurationManagerTest {
    public static void main(String[] args) {
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();
        
        config1.setProperty("app.name", "HER Service");
        
        // Should print: HER Service
        System.out.println(config2.getProperty("app.name"));
        
        // Should print: true (same instance)
        System.out.println(config1 == config2);
    }
}
```

### Expected Output
```
HER Service
true
```

---

## 📝 Exercise 2: Implement Enum Singleton

### Task
Create a `DatabaseConnection` class using Enum singleton pattern.

### Requirements
- Use enum
- Method: `connect()` - prints "Connected to database"
- Method: `disconnect()` - prints "Disconnected from database"
- Method: `executeQuery(String query)` - prints the query

### Template
```java
package LLD.patterns.creational.singleton.enumsingleton;

public enum DatabaseConnection {
    // TODO: Implement enum singleton
    
    public void connect() {
        // TODO: Implement
    }
    
    public void disconnect() {
        // TODO: Implement
    }
    
    public void executeQuery(String query) {
        // TODO: Implement
    }
}
```

### Test Your Implementation
```java
public class DatabaseConnectionTest {
    public static void main(String[] args) {
        DatabaseConnection db = DatabaseConnection.INSTANCE;
        
        db.connect();
        db.executeQuery("SELECT * FROM users");
        db.disconnect();
    }
}
```

### Expected Output
```
Connected to database
Executing query: SELECT * FROM users
Disconnected from database
```

---

## 📝 Exercise 3: Thread-Safety Challenge

### Task
Demonstrate the thread-safety issue with naive singleton implementation.

### Part A: Broken Singleton
```java
package LLD.patterns.creational.singleton.threadsafety;

public class BrokenSingleton {
    private static BrokenSingleton instance;
    private int counter = 0;
    
    private BrokenSingleton() {
        // Simulate slow initialization
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static BrokenSingleton getInstance() {
        if (instance == null) {
            instance = new BrokenSingleton();
        }
        return instance;
    }
    
    public void incrementCounter() {
        counter++;
    }
    
    public int getCounter() {
        return counter;
    }
}
```

### Part B: Test with Multiple Threads
```java
public class ThreadSafetyTest {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                BrokenSingleton singleton = BrokenSingleton.getInstance();
                System.out.println("Thread " + Thread.currentThread().getName() + 
                                   " got instance: " + singleton.hashCode());
            });
            threads[i].start();
        }
        
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
```

### Your Task
1. Run the test - observe multiple instances being created
2. Fix it using Double-Checked Locking
3. Fix it using Bill Pugh approach
4. Compare the results

---

## 📝 Exercise 4: Real-World Scenario - Logger

### Task
Implement a `Logger` singleton similar to how it's used in HER service.

### Requirements
- Use Bill Pugh singleton
- Methods:
  - `info(String message)` - prints "[INFO] message"
  - `error(String message)` - prints "[ERROR] message"
  - `debug(String message)` - prints "[DEBUG] message"
- Add timestamp to each log
- Make it thread-safe

### Template
```java
package LLD.patterns.creational.singleton.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    
    private static final DateTimeFormatter formatter = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    // TODO: Implement Bill Pugh singleton
    
    public void info(String message) {
        log("INFO", message);
    }
    
    public void error(String message) {
        log("ERROR", message);
    }
    
    public void debug(String message) {
        log("DEBUG", message);
    }
    
    private void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println(String.format("[%s] [%s] %s", timestamp, level, message));
    }
}
```

### Test Your Implementation
```java
public class LoggerTest {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        
        logger.info("Application started");
        logger.debug("Loading configuration");
        logger.error("Failed to connect to database");
    }
}
```

### Expected Output (with current timestamp)
```
[2024-12-04 10:30:45] [INFO] Application started
[2024-12-04 10:30:45] [DEBUG] Loading configuration
[2024-12-04 10:30:45] [ERROR] Failed to connect to database
```

---

## 📝 Exercise 5: Mimic HER Service - Metric Publisher

### Task
Create a simplified version of `MetricPublisher` similar to HER service.

### Requirements
- Create interface `IMetricPublisher`
- Create `FakeMetricPublisher` (for testing)
- Create `CloudWatchMetricPublisher` (singleton)
- Create `MetricPublisherFactory` (factory + singleton)

### Part A: Interface
```java
package LLD.patterns.creational.singleton.metrics;

public interface IMetricPublisher {
    void publish(String metricName, double value);
}
```

### Part B: Fake Implementation (for testing)
```java
public class FakeMetricPublisher implements IMetricPublisher {
    @Override
    public void publish(String metricName, double value) {
        System.out.println("[FAKE] Metric: " + metricName + " = " + value);
    }
}
```

### Part C: Real Implementation (Singleton)
```java
public class CloudWatchMetricPublisher implements IMetricPublisher {
    
    private static CloudWatchMetricPublisher instance;
    
    private CloudWatchMetricPublisher() {
        System.out.println("Initializing CloudWatch client...");
    }
    
    public static CloudWatchMetricPublisher getInstance() {
        if (instance == null) {
            instance = new CloudWatchMetricPublisher();
        }
        return instance;
    }
    
    @Override
    public void publish(String metricName, double value) {
        System.out.println("[CloudWatch] Publishing: " + metricName + " = " + value);
    }
}
```

### Part D: Factory (Your Task)
```java
public class MetricPublisherFactory {
    
    private static IMetricPublisher metricPublisher = null;
    
    // TODO: Implement getInstance() method
    // Should return CloudWatchMetricPublisher by default
    
    // TODO: Implement setInstance() method for testing
    // Should allow injecting FakeMetricPublisher
}
```

### Test Your Implementation
```java
public class MetricPublisherTest {
    public static void main(String[] args) {
        // Test 1: Normal usage
        IMetricPublisher publisher1 = MetricPublisherFactory.getInstance();
        publisher1.publish("PDFGenerated", 1.0);
        
        // Test 2: Same instance
        IMetricPublisher publisher2 = MetricPublisherFactory.getInstance();
        System.out.println("Same instance? " + (publisher1 == publisher2));
        
        // Test 3: Testing with fake
        MetricPublisherFactory.setInstance(new FakeMetricPublisher());
        IMetricPublisher fakePublisher = MetricPublisherFactory.getInstance();
        fakePublisher.publish("TestMetric", 42.0);
    }
}
```

---

## 📝 Exercise 6: Spring Singleton Simulation

### Task
Simulate Spring's singleton bean behavior.

### Requirements
- Create a simple `BeanContainer` class
- Store beans in a Map
- Implement `registerBean()` and `getBean()` methods
- Ensure only one instance per bean type

### Template
```java
package LLD.patterns.creational.singleton.spring;

import java.util.HashMap;
import java.util.Map;

public class BeanContainer {
    
    private static BeanContainer instance;
    private Map<Class<?>, Object> beans = new HashMap<>();
    
    private BeanContainer() {}
    
    public static BeanContainer getInstance() {
        if (instance == null) {
            instance = new BeanContainer();
        }
        return instance;
    }
    
    public <T> void registerBean(Class<T> clazz, T bean) {
        // TODO: Store bean in map
    }
    
    public <T> T getBean(Class<T> clazz) {
        // TODO: Return bean from map
        // Cast to correct type
        return null;
    }
}
```

### Test Your Implementation
```java
// Sample service
class UserService {
    public void createUser(String name) {
        System.out.println("Creating user: " + name);
    }
}

public class BeanContainerTest {
    public static void main(String[] args) {
        BeanContainer container = BeanContainer.getInstance();
        
        // Register bean
        container.registerBean(UserService.class, new UserService());
        
        // Get bean
        UserService service1 = container.getBean(UserService.class);
        UserService service2 = container.getBean(UserService.class);
        
        service1.createUser("John");
        
        // Should print: true (same instance)
        System.out.println("Same instance? " + (service1 == service2));
    }
}
```

---

## 📝 Exercise 7: Breaking Singleton with Reflection

### Task
Demonstrate how reflection can break singleton and how to prevent it.

### Part A: Break It
```java
package LLD.patterns.creational.singleton.reflection;

import java.lang.reflect.Constructor;

public class ReflectionAttack {
    public static void main(String[] args) throws Exception {
        // Get first instance normally
        Singleton instance1 = Singleton.getInstance();
        
        // Break singleton using reflection
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton instance2 = constructor.newInstance();
        
        System.out.println("Instance 1 hash: " + instance1.hashCode());
        System.out.println("Instance 2 hash: " + instance2.hashCode());
        System.out.println("Same instance? " + (instance1 == instance2));
    }
}
```

### Part B: Prevent It (Your Task)
Modify the Singleton class to throw an exception if someone tries to create a second instance:

```java
public class Singleton {
    private static Singleton instance;
    
    private Singleton() {
        // TODO: Add check - if instance already exists, throw exception
    }
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

---

## 🎓 Challenge Exercise: HER Service Scenario

### Scenario
You're building a PDF generation service (like HER service). You need:
1. A `PDFConfigManager` (singleton) - stores PDF settings
2. A `MetricCollector` (singleton) - collects metrics
3. A `PDFGenerator` (NOT singleton) - generates PDFs

### Requirements
- `PDFConfigManager`: Bill Pugh singleton, stores page size, margins, etc.
- `MetricCollector`: Enum singleton, tracks PDFs generated, errors, etc.
- `PDFGenerator`: Regular class, uses both singletons

### Your Task
Implement all three classes and demonstrate:
1. Multiple PDFGenerator instances
2. Single PDFConfigManager instance
3. Single MetricCollector instance
4. PDFGenerator using both singletons

---

## ✅ Solutions

Solutions are available in separate files:
- `solutions/Exercise1_BillPugh.java`
- `solutions/Exercise2_Enum.java`
- `solutions/Exercise3_ThreadSafety.java`
- `solutions/Exercise4_Logger.java`
- `solutions/Exercise5_MetricPublisher.java`
- `solutions/Exercise6_BeanContainer.java`
- `solutions/Exercise7_ReflectionProof.java`
- `solutions/Challenge_HERService.java`

---

## 📊 Self-Assessment Checklist

After completing exercises, check if you can:

- [ ] Implement eager initialization singleton
- [ ] Implement lazy initialization with DCL
- [ ] Implement Bill Pugh singleton
- [ ] Implement enum singleton
- [ ] Explain thread-safety issues
- [ ] Make singleton reflection-proof
- [ ] Make singleton serialization-safe
- [ ] Write testable singleton code
- [ ] Identify when to use singleton
- [ ] Identify when NOT to use singleton

---

## 🚀 Next Steps

1. Complete all exercises
2. Compare your solutions with provided solutions
3. Study real HER service code:
   - `AwsMetricPublisher.java`
   - `MetricPublisherFactory.java`
   - `BidgelySpringAppContext.java`
4. Move to **Factory Pattern** (next creational pattern)

---

**Remember**: The best way to learn is by doing! Don't just read - implement and experiment! 🎯

