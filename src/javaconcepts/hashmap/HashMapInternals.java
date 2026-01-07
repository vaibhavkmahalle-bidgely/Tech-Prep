package javaconcepts.hashmap;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HashMapInternals {

    /*
    ================================================================================================
                                        HASHMAP OVERVIEW
    ================================================================================================

    DEFINITION:
    ----------
    Hash table implementation of Map interface storing key-value pairs.

    HIERARCHY:
    ---------
    HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable

    CHARACTERISTICS:
    ---------------
    ✅ One null key, multiple null values allowed
    ✅ Not synchronized (not thread-safe)
    ✅ No ordering guarantee
    ✅ O(1) average time for get/put
    ✅ Unique keys, duplicate values allowed

    STRUCTURE:
    ---------
    - Array of Node<K,V>[] buckets
    - Buckets: Linked list (default) or Red-Black Tree (Java 8+, when bucket size > 8)
    - Default capacity: 16
    - Default load factor: 0.75
    - Max capacity: 2^30
    - Resize: When size > threshold (capacity × loadFactor)

    USE CASES:
    ---------
    ✅ Fast lookups, order irrelevant, single-threaded
    ❌ Thread-safety → ConcurrentHashMap
    ❌ Insertion order → LinkedHashMap
    ❌ Sorted order → TreeMap

    ================================================================================================
                                    INTERNAL WORKING
    ================================================================================================

    NODE STRUCTURE:
    --------------
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;    // Cached hash
        final K key;
        V value;
        Node<K,V> next;    // For chaining
    }

    HOW put(K key, V value) WORKS:
    ------------------------------
    1. Hash Calculation
       hash = key.hashCode() ^ (key.hashCode() >>> 16)
       Purpose: Spread high bits to low bits for better distribution

    2. Bucket Index
       index = (capacity - 1) & hash
       Why: Faster than hash % capacity (works when capacity is power of 2)

    3. Insert/Update
       a) Empty bucket → Create new Node at table[index]
       b) Collision → Traverse list/tree:
          - If key exists (hash matches AND key.equals()) → Replace value
          - Else → Add new node

    4. Treeify (Java 8+)
       If bucket size > 8 AND capacity >= 64 → Convert list to Red-Black Tree
       Improves worst-case from O(n) to O(log n)

    5. Resize
       If size > threshold → Double capacity, rehash all entries

    HOW get(Object key) WORKS:
    -------------------------
    1. Calculate hash: hash = key.hashCode() ^ (key.hashCode() >>> 16)
    2. Find bucket: index = (capacity - 1) & hash
    3. Search:
       - Empty bucket → return null
       - Check first node → if match return value
       - Tree → O(log n) search
       - List → O(n) traversal
       - No match → return null

    ================================================================================================
                                    COLLISION HANDLING
    ================================================================================================

    COLLISION: Two keys hash to same bucket index (e.g., "Aa" and "BB" both → 2112)

    RESOLUTION: Separate Chaining
    - Bucket stores linked list/tree of nodes
    - Java 7: Always linked list
    - Java 8+: List → Tree when bucket size > 8 AND capacity >= 64

    LINKED LIST (small buckets):
    - Insert: O(1), Search: O(n), Delete: O(n)

    RED-BLACK TREE (large buckets, Java 8+):
    - Insert: O(log n), Search: O(log n), Delete: O(log n)
    - Trigger: Bucket size > 8 AND capacity >= 64
    - Revert to list: Bucket size < 6

    EXAMPLE:
    Bucket[5] → Node("Aa",1) → Node("BB",2) → null

    ================================================================================================
                                    RESIZING
    ================================================================================================

    TRIGGER: size > threshold (capacity × loadFactor)
    Example: capacity=16, loadFactor=0.75 → threshold=12 → resize at 13th element

    PROCESS:
    1. Create new array (capacity × 2)
    2. Rehash all entries to new buckets
    3. Update table and threshold

    COST: O(n) - must process all entries
    TIP: Set initial capacity to avoid resizing

    ================================================================================================
                                    CONSTANTS
    ================================================================================================

    DEFAULT_INITIAL_CAPACITY = 16
    MAXIMUM_CAPACITY = 2^30
    DEFAULT_LOAD_FACTOR = 0.75
    TREEIFY_THRESHOLD = 8        // List → Tree
    UNTREEIFY_THRESHOLD = 6      // Tree → List
    MIN_TREEIFY_CAPACITY = 64    // Min capacity for treeification

    ================================================================================================
                                hashCode() & equals()
    ================================================================================================

    ROLE:
    - hashCode() → Determines bucket index
    - equals() → Finds exact key within bucket

    CONTRACT:
    ✅ a.equals(b) == true → a.hashCode() == b.hashCode() (MUST)
    ❌ a.hashCode() == b.hashCode() → a.equals(b) (MAY be true/false)

    BAD IMPLEMENTATION:
    class BadKey {
        public int hashCode() { return 1; }  // All keys → same bucket → O(n)
    }

    GOOD IMPLEMENTATION:
    class GoodKey {
        int id; String name;
        public int hashCode() { return Objects.hash(id, name); }
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof GoodKey)) return false;
            GoodKey k = (GoodKey) o;
            return id == k.id && Objects.equals(name, k.name);
        }
    }

    ================================================================================================
                                    CONSTRUCTORS
    ================================================================================================

    1. HashMap()                                    // capacity=16, loadFactor=0.75
    2. HashMap(int initialCapacity)                // loadFactor=0.75
    3. HashMap(int initialCapacity, float loadFactor)
    4. HashMap(Map<? extends K, ? extends V> m)    // Copy constructor

    ================================================================================================
                                    BASIC METHODS (8)
    ================================================================================================

    1. V put(K key, V value)              // Add/update, returns old value or null
    2. V get(Object key)                  // Returns value or null
    3. V remove(Object key)               // Remove, returns old value or null
    4. boolean containsKey(Object key)    // O(1) average
    5. boolean containsValue(Object value)// O(n) - scans all values
    6. int size()                         // Number of entries
    7. boolean isEmpty()                  // size() == 0
    8. void clear()                       // Remove all entries

    ================================================================================================
                                JAVA 8+ METHODS (11)
    ================================================================================================

    9.  V getOrDefault(Object key, V defaultValue)
        // Returns value or defaultValue if key absent

    10. V putIfAbsent(K key, V value)
        // Add only if key absent, returns existing value or null

    11. boolean remove(Object key, Object value)
        // Remove only if key maps to value

    12. V replace(K key, V value)
        // Replace only if key exists, returns old value or null

    13. boolean replace(K key, V oldValue, V newValue)
        // Replace only if key maps to oldValue

    14. V computeIfAbsent(K key, Function<K,V> mappingFunction)
        // Compute value if absent
        // Use: map.computeIfAbsent("list", k -> new ArrayList<>()).add(item)

    15. V computeIfPresent(K key, BiFunction<K,V,V> remappingFunction)
        // Compute new value if present, remove if function returns null
        // Use: map.computeIfPresent("count", (k,v) -> v + 1)

    16. V compute(K key, BiFunction<K,V,V> remappingFunction)
        // Compute value (present or absent), remove if function returns null
        // Use: map.compute("count", (k,v) -> v == null ? 1 : v + 1)

    17. V merge(K key, V value, BiFunction<V,V,V> remappingFunction)
        // If absent → put value, if present → apply function
        // Use: map.merge(word, 1, Integer::sum)  // Word count

    18. void forEach(BiConsumer<K,V> action)
        // Perform action for each entry

    19. void replaceAll(BiFunction<K,V,V> function)
        // Replace all values using function

    ================================================================================================
                                VIEW METHODS (3) - Backed by map
    ================================================================================================

    20. Set<K> keySet()                   // All keys
    21. Collection<V> values()            // All values
    22. Set<Map.Entry<K,V>> entrySet()    // All entries (most efficient for iteration)

    ================================================================================================
                                    OTHER METHODS (2)
    ================================================================================================

    23. void putAll(Map<? extends K,? extends V> m)  // Copy all from another map
    24. Object clone()                               // Shallow copy

    ================================================================================================
                                MAP.ENTRY INTERFACE
    ================================================================================================

    DEFINITION: Nested interface (Map.Entry<K,V>) representing a key-value pair
    PURPOSE: Efficient iteration - direct access to both key and value

    METHODS (9):
    -----------
    1. K getKey()                                    // Get key
    2. V getValue()                                  // Get value
    3. V setValue(V value)                           // Update value, returns old value
    4. boolean equals(Object o)                      // Compare entries
    5. int hashCode()                                // key.hashCode() ^ value.hashCode()

    STATIC COMPARATORS (Java 8+):
    6. comparingByKey()                              // Sort by key (natural order)
    7. comparingByValue()                            // Sort by value (natural order)
    8. comparingByKey(Comparator<K> cmp)             // Sort by key (custom)
    9. comparingByValue(Comparator<V> cmp)           // Sort by value (custom)

    ================================================================================================
                                MAP.ENTRY USAGE
    ================================================================================================

    ITERATION:
    for (Map.Entry<K,V> e : map.entrySet()) {
        K key = e.getKey();
        V value = e.getValue();
    }

    MODIFY VALUES:
    for (Map.Entry<K,V> e : map.entrySet()) {
        if (condition) e.setValue(newValue);  // Updates map
    }

    SORT BY KEY:
    map.entrySet().stream().sorted(Map.Entry.comparingByKey())

    SORT BY VALUE:
    map.entrySet().stream().sorted(Map.Entry.comparingByValue())

    FILTER:
    map.entrySet().stream().filter(e -> e.getValue() > 10)

    ================================================================================================
                                COMMON USE CASES
    ================================================================================================

    FIND MAX/MIN:
    map.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null)
    map.entrySet().stream().min(Map.Entry.comparingByValue()).orElse(null)

    SORTED LIST:
    List<Entry<K,V>> sorted = map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(Collectors.toList())

    FILTER TO NEW MAP:
    Map<K,V> filtered = map.entrySet().stream()
        .filter(e -> e.getValue() > 25)
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue))

    SWAP KEYS & VALUES:
    Map<V,K> swapped = map.entrySet().stream()
        .collect(Collectors.toMap(Entry::getValue, Entry::getKey))

    ================================================================================================
                            EFFICIENCY: entrySet() vs keySet()
    ================================================================================================

    ❌ INEFFICIENT (O(2n)):
    for (K key : map.keySet()) {
        V value = map.get(key);  // Extra O(1) lookup per key
    }

    ✅ EFFICIENT (O(n)):
    for (Map.Entry<K,V> e : map.entrySet()) {
        K key = e.getKey();      // Direct access
        V value = e.getValue();  // Direct access
    }

    ================================================================================================
                                IMPORTANT NOTES
    ================================================================================================

    ✅ Backed by map: setValue() updates original map
    ✅ Cannot add via entrySet().add() - use map.put()
    ✅ Can remove during iteration via iterator.remove()
    ❌ Don't use map.remove() during iteration → ConcurrentModificationException
    ❌ Don't store Entry objects long-term - extract key/value instead

    ================================================================================================
                                KEY CONCEPTS
    ================================================================================================

    LOAD FACTOR:
    - Threshold ratio: size/capacity
    - Default: 0.75 (balance between space and time)
    - Higher → less memory, slower | Lower → more memory, faster

    CAPACITY:
    - Number of buckets (always power of 2)
    - Default: 16, doubles on resize

    FAIL-FAST ITERATOR:
    - Throws ConcurrentModificationException if map modified during iteration
    - Exception: iterator.remove() is safe
    - ❌ for(K key : map.keySet()) { map.remove(key); }  // Throws exception

    THREAD SAFETY:
    - HashMap is NOT thread-safe
    - Use: Collections.synchronizedMap(new HashMap<>()) or ConcurrentHashMap

    NULL HANDLING:
    - One null key, multiple null values allowed
    - get() returns null → key absent OR value is null (use containsKey() to check)

    TIME COMPLEXITY:
    - get/put/remove: O(1) average, O(log n) worst (Java 8+)
    - containsKey: O(1) average
    - containsValue: O(n) always

    ================================================================================================
    */

    public static void main(String[] args) {
        demonstrateInternalWorking();
        System.out.println("\n\n");
        demonstrateHashMapMethods();
        System.out.println("\n\n");
        demonstrateMapEntry();
        System.out.println("\n\n");
        demonstrateHashCodeEquals();
    }

    public static void demonstrateHashMapMethods() {
        System.out.println("========== HASHMAP DEMONSTRATION ==========\n");

        // Creating HashMap
        Map<String, Integer> map = new HashMap<>();

        // 1. put() - Add key-value pairs
        System.out.println("1. put() method:");
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        System.out.println("Map after put: " + map);

        // 2. get() - Retrieve value
        System.out.println("\n2. get() method:");
        System.out.println("Age of Alice: " + map.get("Alice"));

        // 3. containsKey() and containsValue()
        System.out.println("\n3. containsKey() and containsValue():");
        System.out.println("Contains key 'Bob': " + map.containsKey("Bob"));
        System.out.println("Contains value 30: " + map.containsValue(30));

        // 4. size() and isEmpty()
        System.out.println("\n4. size() and isEmpty():");
        System.out.println("Size: " + map.size());
        System.out.println("Is empty: " + map.isEmpty());

        // 5. getOrDefault()
        System.out.println("\n5. getOrDefault():");
        System.out.println("Age of David (not exists): " + map.getOrDefault("David", 0));

        // 6. putIfAbsent()
        System.out.println("\n6. putIfAbsent():");
        map.putIfAbsent("Alice", 40); // Won't update (key exists)
        map.putIfAbsent("David", 28); // Will add (key doesn't exist)
        System.out.println("Map after putIfAbsent: " + map);

        // 7. replace()
        System.out.println("\n7. replace():");
        map.replace("Bob", 31);
        System.out.println("Map after replace: " + map);

        // 8. computeIfAbsent()
        System.out.println("\n8. computeIfAbsent():");
        map.computeIfAbsent("Eve", k -> 22);
        System.out.println("Map after computeIfAbsent: " + map);

        // 9. computeIfPresent()
        System.out.println("\n9. computeIfPresent():");
        map.computeIfPresent("Alice", (k, v) -> v + 1);
        System.out.println("Map after computeIfPresent: " + map);

        // 10. merge()
        System.out.println("\n10. merge():");
        map.merge("Alice", 5, Integer::sum);
        System.out.println("Map after merge: " + map);

        // 11. keySet(), values(), entrySet()
        System.out.println("\n11. View methods:");
        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());
        System.out.println("Entries: " + map.entrySet());

        // 12. forEach()
        System.out.println("\n12. forEach():");
        map.forEach((k, v) -> System.out.println(k + " -> " + v));

        // 13. remove()
        System.out.println("\n13. remove():");
        map.remove("Charlie");
        System.out.println("Map after remove: " + map);

        // 14. clear()
        System.out.println("\n14. clear():");
        map.clear();
        System.out.println("Map after clear: " + map);
        System.out.println("Is empty: " + map.isEmpty());
    }

    public static void demonstrateMapEntry() {
        System.out.println("========== MAP.ENTRY DEMONSTRATION ==========\n");

        // Create sample map
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 92);
        scores.put("Charlie", 78);
        scores.put("David", 95);
        scores.put("Eve", 88);

        System.out.println("Original Map: " + scores);

        // 1. Basic iteration using Map.Entry
        System.out.println("\n1. Iterating using Map.Entry (for-each):");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " scored " + entry.getValue());
        }

        // 2. Using Iterator with Map.Entry
        System.out.println("\n2. Iterating using Iterator:");
        Iterator<Map.Entry<String, Integer>> iterator = scores.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // 3. Modifying values using setValue()
        System.out.println("\n3. Modifying values using setValue():");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            if (entry.getValue() < 80) {
                System.out.println("Boosting " + entry.getKey() + "'s score from " + entry.getValue());
                entry.setValue(entry.getValue() + 5); // Add bonus points
            }
        }
        System.out.println("Map after modification: " + scores);

        // 4. Sorting by key (ascending)
        System.out.println("\n4. Sorting by key (ascending):");
        scores.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));

        // 5. Sorting by value (descending)
        System.out.println("\n5. Sorting by value (descending - highest score first):");
        scores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));

        // 6. Finding max entry by value
        System.out.println("\n6. Finding student with highest score:");
        Map.Entry<String, Integer> topScorer = scores.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        if (topScorer != null) {
            System.out.println("Top scorer: " + topScorer.getKey() + " with score " + topScorer.getValue());
        }

        // 7. Finding min entry by value
        System.out.println("\n7. Finding student with lowest score:");
        Map.Entry<String, Integer> lowestScorer = scores.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElse(null);
        if (lowestScorer != null) {
            System.out.println("Lowest scorer: " + lowestScorer.getKey() + " with score " + lowestScorer.getValue());
        }

        // 8. Filtering entries
        System.out.println("\n8. Students who scored above 85:");
        scores.entrySet().stream()
                .filter(entry -> entry.getValue() > 85)
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));

        // 9. Collecting filtered entries to new map
        System.out.println("\n9. Creating new map with only high scorers (>85):");
        Map<String, Integer> highScorers = scores.entrySet().stream()
                .filter(entry -> entry.getValue() > 85)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("High scorers: " + highScorers);

        // 10. Converting to sorted list
        System.out.println("\n10. Top 3 scorers (as list):");
        List<Map.Entry<String, Integer>> top3 = scores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toList());
        for (int i = 0; i < top3.size(); i++) {
            Map.Entry<String, Integer> entry = top3.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " = " + entry.getValue());
        }

        // 11. Swapping keys and values
        System.out.println("\n11. Swapping keys and values (score -> name):");
        Map<Integer, String> swapped = scores.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        System.out.println("Swapped map: " + swapped);

        // 12. Conditional update based on key
        System.out.println("\n12. Giving bonus to students whose name starts with 'A':");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            if (entry.getKey().startsWith("A")) {
                System.out.println("Bonus for " + entry.getKey() + ": " + entry.getValue() + " -> " + (entry.getValue() + 10));
                entry.setValue(entry.getValue() + 10);
            }
        }
        System.out.println("Map after bonus: " + scores);

        // 13. Demonstrating efficiency difference
        System.out.println("\n13. Efficiency comparison:");
        System.out.println("❌ INEFFICIENT way (keySet + get):");
        long start1 = System.nanoTime();
        for (String key : scores.keySet()) {
            Integer value = scores.get(key); // Extra lookup
        }
        long end1 = System.nanoTime();
        System.out.println("Time taken: " + (end1 - start1) + " ns");

        System.out.println("✅ EFFICIENT way (entrySet):");
        long start2 = System.nanoTime();
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
        }
        long end2 = System.nanoTime();
        System.out.println("Time taken: " + (end2 - start2) + " ns");
    }

    public static void demonstrateInternalWorking() {
        System.out.println("========== HASHMAP INTERNAL WORKING DEMONSTRATION ==========\n");

        // 1. Understanding Hash Code and Index Calculation
        System.out.println("1. Hash Code and Index Calculation:");
        String key1 = "Alice";
        String key2 = "Bob";

        int hash1 = key1.hashCode();
        int hash2 = key2.hashCode();

        System.out.println("Key: " + key1 + " → hashCode: " + hash1);
        System.out.println("Key: " + key2 + " → hashCode: " + hash2);

        // Simulating HashMap's hash function
        int capacity = 16;
        int index1 = (capacity - 1) & hash1;
        int index2 = (capacity - 1) & hash2;

        System.out.println("Bucket index for " + key1 + ": " + index1);
        System.out.println("Bucket index for " + key2 + ": " + index2);

        // 2. Demonstrating Collision
        System.out.println("\n2. Collision Example:");
        // These strings have same hashCode in Java
        String collisionKey1 = "Aa";
        String collisionKey2 = "BB";

        System.out.println("Key: " + collisionKey1 + " → hashCode: " + collisionKey1.hashCode());
        System.out.println("Key: " + collisionKey2 + " → hashCode: " + collisionKey2.hashCode());
        System.out.println("Both have SAME hashCode! This is a collision.");

        Map<String, Integer> collisionMap = new HashMap<>();
        collisionMap.put(collisionKey1, 1);
        collisionMap.put(collisionKey2, 2);

        System.out.println("Map: " + collisionMap);
        System.out.println("Both keys stored successfully using separate chaining!");

        // 3. Demonstrating Capacity and Load Factor
        System.out.println("\n3. Capacity and Load Factor:");
        Map<Integer, String> capacityDemo = new HashMap<>(4, 0.75f);
        System.out.println("Initial capacity: 4, Load factor: 0.75");
        System.out.println("Threshold (resize trigger): 4 * 0.75 = 3");

        System.out.println("\nAdding elements:");
        for (int i = 1; i <= 5; i++) {
            capacityDemo.put(i, "Value" + i);
            System.out.println("Added element " + i + ", Size: " + capacityDemo.size());
            if (i == 3) {
                System.out.println("  → Threshold reached! Next insertion will trigger resize.");
            }
            if (i == 4) {
                System.out.println("  → Resizing occurred! New capacity: 8, New threshold: 6");
            }
        }

        // 4. Demonstrating why powers of 2 are used
        System.out.println("\n4. Why Capacity is Power of 2:");
        int[] capacities = {16, 32, 64};
        int testHash = 12345;

        for (int cap : capacities) {
            int index = (cap - 1) & testHash;
            int indexMod = testHash % cap;
            System.out.println("Capacity: " + cap +
                             " → (cap-1) & hash = " + index +
                             " | hash % cap = " + indexMod +
                             " (Same result, but & is faster!)");
        }

        // 5. Demonstrating null key handling
        System.out.println("\n5. Null Key Handling:");
        Map<String, Integer> nullKeyMap = new HashMap<>();
        nullKeyMap.put(null, 100);
        nullKeyMap.put("key1", 200);
        nullKeyMap.put(null, 300);  // Replaces previous null key value

        System.out.println("Map with null key: " + nullKeyMap);
        System.out.println("Value for null key: " + nullKeyMap.get(null));
        System.out.println("HashMap allows ONE null key!");

        // 6. Performance comparison: Good vs Bad hashCode
        System.out.println("\n6. Impact of hashCode() Implementation:");
        System.out.println("Creating 1000 entries with good hashCode distribution...");
        Map<Integer, String> goodHashMap = new HashMap<>();
        long start1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            goodHashMap.put(i, "Value" + i);
        }
        long end1 = System.nanoTime();
        System.out.println("Time with good hashCode: " + (end1 - start1) + " ns");

        System.out.println("\nNote: With bad hashCode (all keys → same bucket),");
        System.out.println("performance would degrade to O(n) instead of O(1)!");
    }

    public static void demonstrateHashCodeEquals() {
        System.out.println("========== HASHCODE & EQUALS DEMONSTRATION ==========\n");

        // Custom class with proper hashCode and equals
        class Person {
            String name;
            int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, age);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Person)) return false;
                Person person = (Person) o;
                return age == person.age && Objects.equals(name, person.name);
            }

            @Override
            public String toString() {
                return name + "(" + age + ")";
            }
        }

        // 1. Demonstrating proper hashCode and equals
        System.out.println("1. Proper hashCode() and equals() implementation:");
        Map<Person, String> personMap = new HashMap<>();

        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Alice", 25);  // Same content as p1
        Person p3 = new Person("Bob", 30);

        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1 == p2: " + (p1 == p2));

        personMap.put(p1, "Engineer");
        System.out.println("\nAdded p1 to map: " + personMap);

        System.out.println("Getting value using p2 (different object, same content): " + personMap.get(p2));
        System.out.println("✅ Works because hashCode() and equals() are properly implemented!");

        // 2. Demonstrating the contract
        System.out.println("\n2. hashCode() and equals() Contract:");
        System.out.println("Rule: If a.equals(b) → a.hashCode() == b.hashCode()");
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode()));
        System.out.println("✅ Contract satisfied!");

        System.out.println("\np1.equals(p3): " + p1.equals(p3));
        System.out.println("p1.hashCode() == p3.hashCode(): " + (p1.hashCode() == p3.hashCode()));
        System.out.println("✅ Different objects can have different hashCodes!");

        // 3. What happens without proper equals/hashCode
        System.out.println("\n3. Without proper hashCode/equals (using Object's default):");
        class BadPerson {
            String name;
            int age;
            BadPerson(String name, int age) {
                this.name = name;
                this.age = age;
            }
            @Override
            public String toString() {
                return name + "(" + age + ")";
            }
            // No hashCode() or equals() override - uses Object's default
        }

        Map<BadPerson, String> badMap = new HashMap<>();
        BadPerson bp1 = new BadPerson("Alice", 25);
        BadPerson bp2 = new BadPerson("Alice", 25);

        badMap.put(bp1, "Engineer");
        System.out.println("Added bp1 to map");
        System.out.println("Getting value using bp2 (same content): " + badMap.get(bp2));
        System.out.println("❌ Returns null! Because Object's default equals() uses ==");
        System.out.println("bp1 == bp2: " + (bp1 == bp2) + " (different objects in memory)");

        // 4. String's hashCode implementation
        System.out.println("\n4. String's hashCode() implementation:");
        String s1 = "Hello";
        String s2 = new String("Hello");
        String s3 = "World";

        System.out.println("s1: \"" + s1 + "\" → hashCode: " + s1.hashCode());
        System.out.println("s2: \"" + s2 + "\" → hashCode: " + s2.hashCode());
        System.out.println("s3: \"" + s3 + "\" → hashCode: " + s3.hashCode());
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.hashCode() == s2.hashCode(): " + (s1.hashCode() == s2.hashCode()));
        System.out.println("✅ String properly implements hashCode() and equals()!");
    }
}
