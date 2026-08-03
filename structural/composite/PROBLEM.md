# Composite Pattern

This directory contains two simple and classic composite pattern scenarios:
- **Java**: File System Hierarchy (Files & Folders)
- **Ruby**: Graphic Drawing Tree (Shapes & Compound Objects)

---

## Problem 1 (Java): File System Hierarchy

### Problem Description
Design a file system representation where both individual `File` objects (leaves) and `Folder` objects (composites containing files or other folders) can be treated uniformly.

- Define a common interface or abstract class `FileSystemComponent` with methods `getSize()` and `print(String indent)`.
- A `File` has a name and a specific file size. Calling `getSize()` returns its size.
- A `Folder` has a name and can hold multiple `FileSystemComponent` items (both files and sub-folders). Calling `getSize()` on a folder recursively calculates the total size of everything inside it.
- Client code should be able to treat individual files and composite folders identically when computing total size or printing the tree hierarchy.

---

## Problem 2 (Ruby): Graphic Drawing Tree

### Problem Description
Design a simple graphic rendering system where individual shapes and grouped shapes can be rendered together.

- The leaf objects are `Circle` and `Square`, each implementing a `render` method that returns its string representation.
- The composite object is `CompoundGraphic`, which holds a collection of graphic objects (shapes or other compound graphics).
- Calling `render` on a `CompoundGraphic` delegates to all contained elements and returns their combined rendering.
- Leverage Ruby's dynamic typing/Enumerable mixins to manage child elements easily without rigid class hierarchies.

---

### Constraints & Requirements
1. The code must be runnable in both Java and Ruby, demonstrating uniform operations on single objects and compositions.
2. For Java, implement `getSize()` recursively across nested folders and files.
3. For Ruby, demonstrate building a nested tree of shapes and compound graphics, calling `render` on the root.

### Reflection: Java vs. Ruby
Compare the implementations:
- **Java**: How does having a shared interface/abstract class enforce type safety when adding children to composites?
- **Ruby**: How does duck typing simplify composite structure management compared to explicit component interfaces?
