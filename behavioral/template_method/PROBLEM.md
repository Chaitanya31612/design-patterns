# Template Method Pattern

This directory contains two simple and classic template method pattern scenarios:
- **Java**: Data Processing Pipeline (CSV vs JSON Data Exporter)
- **Ruby**: Beverage Preparation (Tea vs Coffee)

---

## Problem 1 (Java): Data Processing Pipeline

### Problem Description
Implement a data mining pipeline that extracts, parses, and exports data from different file formats.

- Create an abstract base class `DataProcessor` with a `final` template method `process(String filePath)` that defines the fixed algorithm steps:
  1. `openFile(filePath)` (common implementation in base class)
  2. `extractData()` (abstract step - implemented by subclasses)
  3. `parseData()` (abstract step - implemented by subclasses)
  4. `closeFile()` (common implementation in base class)
- Implement two concrete subclasses:
  - `CSVDataProcessor`: Implements CSV-specific extraction and parsing.
  - `JSONDataProcessor`: Implements JSON-specific extraction and parsing.
- Ensure the template method enforces the exact execution order while delegating format-specific steps to the subclasses.

---

## Problem 2 (Ruby): Beverage Preparation

### Problem Description
Implement a hot beverage maker that follows a fixed recipe sequence for preparing drinks.

- Create a base class `BeverageMaker` with a template method `prepare_recipe`:
  1. `boil_water` (shared step)
  2. `brew` (overridden by subclasses)
  3. `pour_in_cup` (shared step)
  4. `add_condiments` (overridden by subclasses)
  5. `customer_wants_condiments?` (an optional hook method that defaults to `true`)
- Implement concrete subclasses `Coffee` and `Tea`.
- In Ruby, demonstrate how hooks can be overridden conditionally by the client or subclass to customize behavior without altering the template algorithm.

---

### Constraints & Requirements
1. The code must be runnable in both Java and Ruby, with output showing step-by-step algorithm execution.
2. For Java, use `final` on the template method to prevent subclasses from overriding the algorithm structure.
3. For Ruby, demonstrate the execution flow including hook overrides.

### Reflection: Java vs. Ruby
Compare the implementations:
- **Java**: How does method visibility (`protected` steps, `public final` template method) enforce algorithm safety?
- **Ruby**: How does Ruby's dynamic nature and optional hook methods make template algorithms flexible?
