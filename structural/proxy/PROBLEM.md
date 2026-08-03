# Proxy Pattern

This directory contains two simple and classic proxy pattern scenarios:
- **Java**: Lazy Loading Image Viewer (Virtual Proxy)
- **Ruby**: Restricted Internet Access (Protection Proxy)

---

## Problem 1 (Java): Lazy Loading Image Viewer (Virtual Proxy)

### Problem Description
Design a high-resolution image viewing component for a gallery application where loading images from disk/network is expensive.

- Define an `Image` interface with a `display()` method.
- `RealImage` implements `Image`. Its constructor loads a heavy image file from disk (simulated by a print statement or short sleep).
- `ProxyImage` also implements `Image` and holds a reference to `RealImage`. 
- `ProxyImage` delays instantiating `RealImage` until `display()` is invoked for the first time. Subsequent calls to `display()` reuse the already-loaded `RealImage` instance.

---

## Problem 2 (Ruby): Restricted Internet Access (Protection Proxy)

### Problem Description
Implement a network access controller that acts as a proxy for connecting to websites, enforcing domain restriction rules.

- Create a target class `RealInternet` with a method `connect_to(host)` that prints `"Connecting to " + host`.
- Create a `ProxyInternet` class that wraps `RealInternet` and maintains a list of banned/restricted sites (e.g. `["banned.com", "malware.org"]`).
- When `connect_to(host)` is called on `ProxyInternet`:
  - If the host is in the banned list, raise or output an access denied error.
  - If allowed, forward the call to `RealInternet`.

---

### Constraints & Requirements
1. The code must be runnable in both Java and Ruby, demonstrating how the proxy controls access or defers instantiation.
2. For Java, verify that the heavy `RealImage` is only loaded once upon the first call to `display()`.
3. For Ruby, demonstrate blocked connection attempts vs allowed connection attempts.

### Reflection: Java vs. Ruby
Compare the implementations:
- **Java**: How does implementing a shared interface allow the `ProxyImage` to be substituted seamlessly for `RealImage`?
- **Ruby**: How can delegation or dynamic forwarding (`method_missing` or `SimpleDelegator`) simplify building proxies in Ruby?
