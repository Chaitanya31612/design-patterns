# Chain of Responsibility Pattern

This directory contains two simple and classic chain of responsibility pattern scenarios:
- **Java**: Support Desk Escalation (Tier 1 -> Tier 2 -> Tier 3)
- **Ruby**: HTTP Request Middleware Pipeline (Logger -> Auth -> RateLimiter)

---

## Problem 1 (Java): Support Desk Escalation

### Problem Description
Implement a customer support ticket processing system where tickets of varying severity levels are handled by different support tiers.

- Create a `SupportTicket` object containing a severity level: `BASIC`, `INTERMEDIATE`, or `CRITICAL`.
- Create an abstract base handler `SupportHandler` with a `nextHandler` reference and a method `handleRequest(SupportTicket ticket)`.
- Implement concrete handlers:
  1. `JuniorSupport`: Handles `BASIC` tickets. Passes others to next handler.
  2. `SeniorSupport`: Handles `INTERMEDIATE` tickets. Passes others to next handler.
  3. `DirectorSupport`: Handles `CRITICAL` tickets.
- Build a chain (`JuniorSupport` -> `SeniorSupport` -> `DirectorSupport`) and send various tickets through the head of the chain.

---

## Problem 2 (Ruby): HTTP Request Middleware Pipeline

### Problem Description
Implement an HTTP request processing pipeline similar to web framework middleware (Rack/Rails).

- An `HTTPRequest` contains attributes like `:url`, `:authenticated?`, and `:rate_limit_exceeded?`.
- Create a base `Middleware` class that holds a reference to `@next_middleware` and a `call(request)` method.
- Implement middleware handlers:
  1. `LoggingMiddleware`: Logs the request URL and forwards to the next middleware.
  2. `AuthenticationMiddleware`: Checks if `@authenticated?` is true. If false, halts the pipeline with `"401 Unauthorized"`. Otherwise forwards.
  3. `RateLimitMiddleware`: Checks if `@rate_limit_exceeded?` is true. If true, halts with `"429 Too Many Requests"`. Otherwise forwards.
- Build the chain and pass different request scenarios through it.

---

### Constraints & Requirements
1. The code must be runnable in both Java and Ruby, showing how requests pass along the chain or halt early.
2. For Java, link the handlers dynamically (`setNext()`) and process tickets.
3. For Ruby, demonstrate pipeline processing and early termination when authentication or rate limits fail.

### Reflection: Java vs. Ruby
Compare the implementations:
- **Java**: How does the handler base class manage chaining and delegation to `nextHandler`?
- **Ruby**: How does the middleware chain pattern naturally suit Ruby web applications and closures?
