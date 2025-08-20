# 🚦 Circuit Breaker (Theory)

## 1. What is a Circuit Breaker?

Think of a **traffic signal** outside a bridge:  

- **Green (Closed)** → Cars pass normally. (Requests go to service)  
- **Red (Open)** → Bridge broken → Cars blocked. (Requests fail fast)  
- **Yellow (Half-Open)** → A few cars tested.  
  - If safe → turn back Green.  
  - If unsafe → back to Red.  

### 🖥 In Software
- A circuit breaker protects your system when a **downstream service fails** repeatedly.  
- After threshold failures → circuit **opens** and blocks calls.  
- After a cooldown → it **half-opens** and allows a test call.  
- If test succeeds → back to normal (**Closed**).  

### 🎯 Why use it?
- Prevents **wasting resources** on failed calls.  
- Protects from **cascading failures**.  
- Helps the system **recover gracefully**.  

## 2. Class Diagram (UML)

+---------------------+
|     CircuitBreaker  |
+---------------------+
| - state: State      |
| - failureCount: int |
| - failureThreshold: int |
| - resetTimeout: long|
| - lastFailureTime: long |
+---------------------+
| + allowRequest(): boolean  |
| + recordSuccess(): void    |
| + recordFailure(): void    |
| + getState(): State        |
+---------------------+

         |
         v
+---------------------+
|        State        |
+---------------------+
| CLOSED              |
| OPEN                |
| HALF_OPEN           |
+---------------------+

+---------------------+
|   ExternalService   |
+---------------------+
| + call(): String    |
+---------------------+

+---------------------------+
|   CircuitBreakerDemo      |
+---------------------------+
| + main(String[] args): void |
+---------------------------+

## 3. State Transition Diagram

          +---------+
          |  Closed |
          +---------+
             |  (failures >= threshold)
             v
          +---------+
          |   Open  |
          +---------+
             | (after timeout)
             v
          +-------------+
          |  Half-Open  |
          +-------------+
           | success | failure
           v         v
      +---------+  +---------+
      | Closed  |  |   Open  |
      +---------+  +---------+

