# 🎨 Design Patterns in Java


## 🔹 What Are Design Patterns?
- **Definition:** Reusable solutions to common software design problems.  
- **Origin:** Popularized by *Gang of Four (GoF)* book.  
- **Purpose:** 
  - Promote best practices  
  - Reduce code duplication  
  - Improve maintainability and scalability  


## 🏗️ Categories of Design Patterns

### 1. Creational Patterns
👉 Deal with object creation mechanisms.  
- **Singleton** → Ensure only one instance exists.  
- **Factory Method** → Create objects without exposing instantiation logic.  
- **Abstract Factory** → Create families of related objects.  
- **Builder** → Step-by-step object construction.  
- **Prototype** → Create objects by cloning an existing one.  


### 2. Structural Patterns
👉 Deal with class and object composition.  
- **Adapter** → Bridge between incompatible interfaces.  
- **Decorator** → Add responsibilities dynamically without modifying code.  
- **Proxy** → Control access to an object (e.g., caching, lazy init).  
- **Facade** → Provide a simplified interface to a complex system.  
- **Composite** → Treat individual objects and compositions uniformly (tree structures).  
- **Bridge** → Separate abstraction from implementation.  
- **Flyweight** → Optimize memory by sharing common object state.  


### 3. Behavioral Patterns
👉 Deal with communication between objects.  
- **Observer** → One-to-many dependency (event listeners).  
- **Strategy** → Define interchangeable algorithms.  
- **Command** → Encapsulate a request as an object.  
- **Template Method** → Define skeleton, subclasses fill in details.  
- **State** → Change behavior when object state changes.  
- **Chain of Responsibility** → Pass request along a chain until handled.  
- **Mediator** → Encapsulate interactions between multiple objects.  
- **Iterator** → Sequentially access elements of a collection.  
- **Memento** → Save/restore object state (undo functionality).  
- **Interpreter** → Define grammar and interpretation.  
- **Visitor** → Add new operations without modifying objects.  

## ✅ Examples (Quick Java Snippets)

### Singleton
```java
public class Singleton {
    private static final Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }
}
```
