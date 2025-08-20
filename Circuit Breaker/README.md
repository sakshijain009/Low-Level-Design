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

## Why we need it

Imagine **Service A** calls **Service B**.  

- If **B is down or very slow**, A keeps sending requests.  
- Requests **pile up**, threads **block**, queues **fill**, and A also fails.  
- This failure can **cascade** to other services (domino effect).  

✅ The Circuit Breaker avoids this by **failing fast** instead of wasting time on calls that are likely to fail.


## 🔄 States of Circuit Breaker

### **CLOSED**
- All requests are allowed.  
- Failures are counted in a rolling window.  
- If failures cross a threshold → move to **OPEN**.  

### **OPEN**
- Requests are **blocked immediately** (fail fast).  
- After a cool-off period (say 30s), breaker tries to recover → moves to **HALF_OPEN**.  

### **HALF_OPEN**
- Allows only a **limited number of test requests**.  
- If they **succeed** → breaker goes back to **CLOSED**.  
- If they **fail** → breaker goes back to **OPEN**.  


## 🛠 Example

- Service A calls **Payment Service B**.  
- B goes **down**.  
- Circuit breaker notices **5 failures in a row** → trips → moves to **OPEN**.  
- For the next **30s**, A immediately fails requests (returns fallback like: *“Payment system unavailable”*).  
- After **30s**, breaker allows a few trial requests (**HALF_OPEN**).  
  - If **successful** → assume B is healthy → go back to **CLOSED**.  
  - If **fail again** → stay in **OPEN**.  

### 🎯 Benefits
- Prevents **wasting resources** on failed calls.  
- Protects from **cascading failures**.  
- Helps the system **recover gracefully**.  

## 2. Class Diagram (UML)
```txt
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
```

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

