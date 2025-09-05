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
Ensure only **one instance** exists.

```java
public class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {}  // private constructor

    public static Singleton getInstance() {
        return instance;
    }
}
```

### Factory Method
Create objects without exposing instantiation logic.

```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() { System.out.println("Circle"); }
}

class Square implements Shape {
    public void draw() { System.out.println("Square"); }
}

class ShapeFactory {
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) return new Circle();
        if (type.equalsIgnoreCase("square")) return new Square();
        return null;
    }
}

// Usage:
// Shape shape = new ShapeFactory().getShape("circle");
// shape.draw();
```

### Abstract Factory Method
Create families of related objects.

```java
// Product interfaces
interface Animal {
    void speak();
}
interface Food {
    void eat();
}

// Concrete products
class Dog implements Animal {
    public void speak() { System.out.println("Woof!"); }
}
class DogFood implements Food {
    public void eat() { System.out.println("Eating dog food."); }
}

class Cat implements Animal {
    public void speak() { System.out.println("Meow!"); }
}
class CatFood implements Food {
    public void eat() { System.out.println("Eating cat food."); }
}

// Abstract factory
interface PetFactory {
    Animal createAnimal();
    Food createFood();
}

// Concrete factories
class DogFactory implements PetFactory {
    public Animal createAnimal() { return new Dog(); }
    public Food createFood() { return new DogFood(); }
}

class CatFactory implements PetFactory {
    public Animal createAnimal() { return new Cat(); }
    public Food createFood() { return new CatFood(); }
}

// Usage
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        PetFactory factory = new DogFactory();   // Switch to CatFactory easily

        Animal pet = factory.createAnimal();
        Food food = factory.createFood();

        pet.speak();   // Woof!
        food.eat();    // Eating dog food.
    }
}

```
