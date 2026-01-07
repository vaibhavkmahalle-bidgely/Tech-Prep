package javaconcepts.memory;

public class MemoryManagement {
//        ┌─────────────────────────────┐
//        │       JVM Memory            │
//        │ ┌─────────────────────────┐ │
//        │ │   Heap Memory           │ │  → stores objects (instances)
//        │ └─────────────────────────┘ │
//        │ ┌─────────────────────────┐ │
//        │ │   Stack Memory          │ │  → stores local variables, method calls
//        │ └─────────────────────────┘ │
//        │ ┌─────────────────────────┐ │
//        │ │  Method Area (Metaspace)│ │  → stores class-level info, static vars
//        │ └─────────────────────────┘ │
//        └─────────────────────────────┘

//            ┌──────────────────────────────────────────────┐
//            │       1️⃣ Write Code                          │
//            │   You create source file → MyClass.java      │
//            └──────────────────────────────────────────────┘
//            │
//            ▼
//            ┌──────────────────────────────────────────────┐
//            │               2️⃣ Compile Code                │
//            │   Command: javac MyClass.java                 │
//            │   ↓                                           │
//            │   Output: MyClass.class (bytecode file)       │
//            └──────────────────────────────────────────────┘
//            │
//            ▼
//            ┌──────────────────────────────────────────────┐
//            │               3️⃣ Run Program                 │
//            │   Command: java MyClass                      │
//            │   ↓                                          │
//            │   Starts the Java Virtual Machine (JVM)      │
//            └──────────────────────────────────────────────┘
//            │
//            ▼
//            ┌──────────────────────────────────────────────┐
//            │          4️⃣ Class Loading Process             │
//            │   ClassLoaders load MyClass.class:            │
//            │   • Bootstrap → core classes (java.*)         │
//            │   • Platform → ext modules                    │
//            │   • Application → your classes                │
//            │   ↓                                           │
//            │   Loaded into Method Area / Metaspace         │
//            └──────────────────────────────────────────────┘
//            │
//            ▼
//            ┌──────────────────────────────────────────────┐
//            │           5️⃣ Linking & Initialization         │
//            │   - Verify bytecode safety                    │
//            │   - Allocate memory for static fields         │
//            │   - Resolve symbolic references               │
//            │   - Run static initializers                   │
//            └──────────────────────────────────────────────┘
//            │
//            ▼
//            ┌────────────────────────────────────────────── ┐
//            │               6️⃣ Execution Phase              │
//            │   main() starts in a new thread               │
//            │   • Each call → new frame on Stack            │
//            │   • Objects → stored in Heap                  │
//            │   • Class info → in Method Area               │
//            │   • Bytecode → executed by Interpreter/JIT    │
//            └────────────────────────────────────────────── ┘
//            │
//            ▼
//            ┌──────────────────────────────────────────────┐
//            │              7️⃣ Garbage Collection           │
//            │ Unreachable objects → reclaimed automatically│
//            └──────────────────────────────────────────────┘
//            │
//            ▼
//            ┌──────────────────────────────────────────────┐
//            │               8️⃣ JVM Shutdown                │
//            │   All threads end → classes unloaded → exit  │
//            └──────────────────────────────────────────────┘

}
