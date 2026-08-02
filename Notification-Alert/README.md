# Notification Alert System (Observer Design Pattern)

## Overview

This project demonstrates the **Observer Design Pattern** using a simple stock notification system.

Whenever an item's stock changes from **out of stock** to **available**, all registered users are notified through different notification channels (Email, SMS, etc.).

## Design Pattern Used

### Observer Design Pattern

The Observer Pattern establishes a **one-to-many dependency** between objects so that when one object changes its state, all its dependents are notified automatically.

### Components

- **Observable (Publisher)**
- **Observer (Subscriber)**
- **Concrete Observable**
- **Concrete Observers**

# Project Structure

```
Observable/
│
├── StocksObservable.java
└── IphoneObservableImpl.java

Observer/
│
├── NotificationAlertObserver.java
├── EmailNotificationAlertObserverImpl.java
└── SMSNotificationAlertObserverImpl.java
```

# Class Responsibilities

## 1. StocksObservable (Observable Interface)

This interface defines the contract for every observable object.

### Responsibilities

- Register observers
- Remove observers
- Notify all observers
- Update stock
- Get stock count
- Get product description

### Methods

```java
void add(NotificationAlertObserver observer);

void remove(NotificationAlertObserver observer);

void notifyMembers();

void setStockCount(int stockCount);

int getStockCount();

String getDescription();
```

## 2. IphoneObservableImpl (Concrete Observable)

This class implements the observable.

It maintains

- List of observers
- Current stock count

When stock changes from **0** to **available**, it notifies every registered observer.

### Data Members

```java
List<NotificationAlertObserver> observerList;

int stockCount;
```

### Important Methods

### add()

Registers a new observer.

```java
observerList.add(observer);
```

### remove()

Removes an observer.

```java
observerList.remove(observer);
```

### notifyMembers()

Iterates over every observer and calls

```java
observer.update();
```

### setStockCount()

If stock was previously zero, notifications are sent before updating the stock value.

```java
if(stockCount == 0){
    notifyMembers();
}

stockCount = newStockCount;
```

### getDescription()

Returns the product name.

```
Iphone 17 pro max
```

## 3. NotificationAlertObserver (Observer Interface)

Defines a common interface for every notification channel.

```java
void update();
```

Every observer decides what to do when it receives an update.

## 4. EmailNotificationAlertObserverImpl

Concrete observer responsible for Email notifications.

### Data Members

```java
String email;

StocksObservable stocksObservable;
```

The observer stores a reference to the observable so it can fetch product information.

### update()

Whenever notified

```java
sendEmail(
    "Items are back in Stock!",
    stocksObservable.getDescription()
);
```

## 5. SMSNotificationAlertObserverImpl

Concrete observer responsible for SMS notifications.

Structure is identical to Email observer.

When notified

```java
SMS sent with message:
Items are back in Stock!
```

# Working Flow

### Step 1

Create the observable.

```
IphoneObservableImpl
```

↓

### Step 2

Create observers.

```
Email Observer

SMS Observer
```

↓

### Step 3

Register observers.

```
observable.add(emailObserver)

observable.add(smsObserver)
```

↓

### Step 4

Stock becomes available.

```
observable.setStockCount(...)
```

↓

### Step 5

Observable calls

```
notifyMembers()
```

↓

### Step 6

Every observer receives

```
update()
```

↓

### Step 7

Observers send notifications.

```
Email

SMS
```

# Sequence Diagram

```
Customer subscribes
        │
        ▼
Observable
        │
        │ add(observer)
        ▼

Stock becomes available
        │
        ▼
setStockCount()
        │
        ▼
notifyMembers()
        │
        ├──────────────► EmailObserver.update()
        │
        └──────────────► SMSObserver.update()
```

# Advantages

- Loosely coupled design
- Easy to add new notification channels
- Observable does not depend on concrete observer implementations
- Follows the Open/Closed Principle by allowing new observers without modifying existing observable logic


# Possible Improvements

The uploaded implementation demonstrates the Observer pattern effectively, but it can be enhanced by:

- Notifying observers only when stock changes from **0 to a positive value** (the current implementation checks only the previous stock count before updating).
- Replacing `System.out.println()` with actual Email/SMS services.
- Making notification messages configurable.
- Supporting multiple product types instead of returning a hardcoded product description.
- Adding exception handling so one observer failure does not prevent others from being notified.
- Making the observable thread-safe if updates can occur concurrently.


# Design Pattern Summary

```
                 StocksObservable
                       ▲
                       │
          --------------------------
          │                        │
          │                        │
IphoneObservableImpl      (Other Products)

                       │
             notifyMembers()
                       │
         --------------------------
         │                        │
         ▼                        ▼

EmailNotificationObserver   SMSNotificationObserver
```

# SOLID Principles

### Single Responsibility Principle (SRP)

Each class has one responsibility.

- Observable manages stock and subscribers.
- Email observer sends email notifications.
- SMS observer sends SMS notifications.

### Open/Closed Principle (OCP)

New notification channels (Push Notification, WhatsApp, etc.) can be added by implementing the `NotificationAlertObserver` interface without modifying existing classes.

### Dependency Inversion Principle (DIP)

Observers depend on the `StocksObservable` abstraction, and the observable stores subscribers through the `NotificationAlertObserver` interface rather than concrete implementations.
