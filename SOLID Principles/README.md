# 📘 SOLID Principles in Object-Oriented Design

The **SOLID principles** are five design principles intended to make software designs more **understandable, flexible, and maintainable**.  
They are especially useful in **Java, C#, and other OOP languages**.


## 1️⃣ S — Single Responsibility Principle (SRP)

📖 **Definition**:  
A class should have **only one reason to change**.  
Each class should focus on doing **only one thing**.

💡 **Why?**  
- Reduces complexity.  
- Easier to test, maintain, and extend.  
- Prevents a “God Class” that does too much.  

✅ **Example**:  
- ❌ A `User` class handling **data + persistence + email**.  
- ✅ Separate into `User`, `UserRepository`, and `EmailService`.


## 2️⃣ O — Open/Closed Principle (OCP)

📖 **Definition**:  
Software entities (classes, modules, functions) should be **open for extension, but closed for modification**.  

💡 **Why?**  
- You can add **new features** without changing existing code.  
- Prevents introducing new bugs in old code.  
- Encourages **polymorphism** and **abstraction**.

✅ **Example**:  
- ❌ `AreaCalculator` that checks `if (circle) … else if (rectangle)…`.  
- ✅ Use `Shape` interface with `area()` method → add `Triangle` later without changing old code.


## 3️⃣ L — Liskov Substitution Principle (LSP)

📖 **Definition**:  
Subtypes must be **substitutable** for their base types.  
If `T` is a type, then any subtype `S` should be usable in place of `T` without breaking behavior.

💡 **Why?**  
- Prevents **unexpected behavior** when using subclasses.  
- Keeps inheritance hierarchy correct.  

✅ **Example**:  
- ❌ `Penguin` extends `Bird` but throws error in `fly()`.  
- ✅ Split into `FlyingBird` and `NonFlyingBird`. `Sparrow` implements `FlyingBird`, `Penguin` implements `Bird`.


## 4️⃣ I — Interface Segregation Principle (ISP)

📖 **Definition**:  
Clients should **not be forced** to depend on methods they don’t use.  
Prefer **many small interfaces** over a single fat one.

💡 **Why?**  
- Reduces unnecessary dependencies.  
- Makes systems more modular.  
- Improves flexibility for clients.  

✅ **Example**:  
- ❌ `Worker` interface with `work()` and `eat()`. Robots don’t eat!  
- ✅ Split into `Workable` and `Eatable`. `Human` implements both, `Robot` only `Workable`.


## 5️⃣ D — Dependency Inversion Principle (DIP)

📖 **Definition**:  
Depend on **abstractions, not concretions**.  
High-level modules shouldn’t depend on low-level modules; both should depend on interfaces.

💡 **Why?**  
- Improves testability (e.g., use mock services).  
- Makes system more flexible (swap Email with SMS, DB with API).  
- Encourages **loose coupling**.

✅ **Example**:  
- ❌ `Notification` directly depends on `EmailService`.  
- ✅ `Notification` depends on `MessageService` interface → `EmailService`, `SMSService` are interchangeable.


# 🎯 Quick Recap

- **S** → One class = one responsibility.  
- **O** → Extend, don’t modify.  
- **L** → Subclasses should behave like parents.  
- **I** → Prefer small, focused interfaces.  
- **D** → Depend on abstractions, not implementations.  


📌 **Why SOLID matters in interviews?**  
- Shows you understand **clean code and maintainability**.  
- Demonstrates ability to design **scalable, flexible systems**.  
- You can apply these principles to **real-world systems** like payments, notifications, logging, etc.
