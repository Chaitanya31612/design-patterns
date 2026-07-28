# Decorator Pattern

This directory contains two simple and classic decorator scenarios:
- **Java**: Coffee Shop Condiment System (Starbucks Style)
- **Ruby**: HTML Text Editor Styling (Bold, Italic, Underline)

---

## Problem 1 (Java): Coffee Shop Condiment System

### Problem Description
Implement a classic beverage ordering system where you can customize coffee with condiments.
- The base component is a `Beverage` abstract class or interface with `getDescription()` and `getCost()` methods.
- Implement a couple of concrete beverages: `Espresso` and `HouseBlend`.
- Implement a base `CondimentDecorator` (which also extends/implements `Beverage`).
- Create concrete decorators: `Milk`, `Mocha`, and `Whip`.
- The client should be able to instantiate dynamic configurations, such as an Espresso with double Mocha and Whip, and get the accurate description and combined cost.
  ```java
  Beverage beverage = new Whip(new Mocha(new Mocha(new Espresso())));
  ```

---

## Problem 2 (Ruby): HTML Text Editor Styling

### Problem Description
Implement a simple text formatting system for an HTML editor.
- The base component is a `SimpleText` class that has a `render` method returning a plain string.
- Create decorators to format the text:
  1. `BoldDecorator`: Wraps the text inside `<b>` and `</b>` tags.
  2. `ItalicDecorator`: Wraps the text inside `<i>` and `</i>` tags.
  3. `UnderlineDecorator`: Wraps the text inside `<u>` and `</u>` tags.
- The client should be able to stack these decorators in any order:
  ```ruby
  text = UnderlineDecorator.new(BoldDecorator.new(SimpleText.new("Hello World")))
  puts text.render # => <u><b>Hello World</b></u>
  ```

---

### Constraints & Requirements
1. The code must be runnable with output showing the decorated strings (HTML) and beverage descriptions/prices.
2. The decorators must not change the interface of the base objects.

### Reflection: Java vs. Ruby
Compare the implementations:
- **Java**: How does compiler type safety affect how decorators are stacked?
- **Ruby**: How does duck typing allow for wrapping objects without strict interface definitions?
