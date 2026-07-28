# Singleton Pattern

This directory contains two simple and classic singleton scenarios:
- **Java**: Thread-Safe App Logger
- **Ruby**: In-Memory Cache Manager

---

## Problem 1 (Java): Thread-Safe App Logger

### Problem Description
Implement a simple, thread-safe global `Logger` class.
- The `Logger` should have a method `log(String message)` that prints messages to the console with a timestamp or prefix.
- Ensure the constructor is private.
- Implement lazy initialization with thread safety (e.g., using double-checked locking or the Bill Pugh Helper class method) so that if multiple threads try to log concurrently, they all share the exact same `Logger` instance.

---

## Problem 2 (Ruby): In-Memory Cache Manager

### Problem Description
Implement a global, in-memory `CacheManager` class to store temporary key-value pairs (using a Hash).
- The class should provide `write(key, value)`, `read(key)`, and `clear` methods.
- The class constructor must be private.
- Prevent duplication or copying of the singleton instance by disabling or overriding `dup` and `clone`.
- Verify that calling `CacheManager.instance` repeatedly returns the exact same object.

---

### Constraints & Requirements
1. The code must be runnable with output showing how the pattern solves the problem.
2. For Java, demonstrate thread safety by accessing the logger from multiple threads.
3. For Ruby, demonstrate that `dup` and `clone` are protected and fail as expected.

---

### Reflection: Java vs. Ruby (Focus: CacheManager Thread-Safety)

When implementing a thread-safe `CacheManager` singleton, Java and Ruby take fundamentally different approaches to synchronization: Java leverages low-level hardware concurrency (CAS), while Ruby relies on block-level OS locks (Mutex) due to standard library constraints.

#### 1. Java Implementation: Lock-Free Concurrency via CAS
In Java, wrapping a standard `HashMap` in a `synchronized` block degrades performance. The ideal Java `CacheManager` uses **`ConcurrentHashMap`** inside a Bill Pugh Singleton wrapper:

```java
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager {
    
    // Bill Pugh Singleton Holder (Lazy, Thread-Safe)
    private static class Holder {
        private static final CacheManager INSTANCE = new CacheManager();
    }
    
    // ConcurrentHashMap uses CAS under the hood
    private final ConcurrentHashMap<String, Object> store;

    private CacheManager() {
        this.store = new ConcurrentHashMap<>();
    }

    public static CacheManager getInstance() {
        return Holder.INSTANCE;
    }

    // Write operation: Thread-safe, lock-free unless bucket collision occurs
    public void write(String key, Object value) {
        store.put(key, value);
    }

    // Read operation: Completely lock-free
    public Object read(String key) {
        return store.get(key);
    }
}
```

##### How CAS (Compare-And-Swap) Works in Java's `ConcurrentHashMap`:
*   **No Global Lock**: Unlike `Hashtable` or `Collections.synchronizedMap`, `ConcurrentHashMap` never locks the entire map.
*   **Lock-Free Reads**: Reads are completely non-blocking and lock-free because the table buckets are declared `volatile`.
*   **CAS for Bucket Insertions**: When inserting a key into an empty bucket, the map uses CPU atomic instructions—like `compareAndSwapObject` (e.g., `CMPXCHG` on x86 architectures)—to place the new node. If no thread modified it in the split-second before, the write succeeds lock-free.
*   **Segmented Locking**: It only falls back to a lock (synchronizing on the head node of a specific bucket) if a collision occurs (i.e. the bucket is already occupied and a linked list/red-black tree needs updating).

---

#### 2. Ruby Implementation: Guarded Mutex Concurrency
Because Ruby's core standard library does not expose CAS-based concurrent collections out of the box, we utilize Ruby's standard `Singleton` module combined with a mutual exclusion lock (`Mutex`).

##### Implementation Reference:
The full implementation can be found here:
*   **CacheManager Definition**: [lib/cache_manager.rb](file:///home/chaitanya/Desktop/Development/learning/swe-mastery-journal/design_patterns/creational/singleton/ruby/lib/cache_manager.rb)
*   **Execution & Test Script**: [main.rb](file:///home/chaitanya/Desktop/Development/learning/swe-mastery-journal/design_patterns/creational/singleton/ruby/main.rb)

##### Key Concepts in the Ruby Code:
*   **`include Singleton`**: Automatically handles lazy instantiation, hides the `.new` method, and overrides `.dup` and `.clone` to prevent copying.
*   **`Mutex#synchronize`**: Ruby wraps each read/write operation inside a mutex block:
    ```ruby
    def write(key, value)
      @lock.synchronize { @store[key] = value }
    end
    ```
    This translates to a POSIX pthread lock at the operating system level. While MRI Ruby has a GVL (Global VM Lock) that prevents parallel execution of Ruby code, a mutex is still essential to ensure atomicity of operations and for compatibility with alternative JRuby/TruffleRuby engines that support true thread parallelism.
