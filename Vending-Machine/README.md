
# 🥤 Vending Machine System Design

## ✅ Functional Requirements

- The system simulates a vending machine for product purchase.
- Users can:
  - Select a product
  - Insert **coins** (no notes)
  - Receive the product if payment is sufficient
  - Get back any remaining change
- The system tracks real-time **product inventory**.
- Product states and actions are handled using a **state machine**.
- All inventory operations are **thread-safe**.


## 🧱 System Components

### 1. `VendingMachine` (Singleton)
- Central controller of the vending machine.
- Maintains:
  - A single instance (Singleton pattern)
  - Machine states (`Idle`, `Ready`, `Dispense`, `ReturnChange`)
  - Inventory of products
  - Selected product
  - Total payment inserted

**Key Methods:**
- `selectProduct(Product product)`
- `insertCoin(Coin coin)`
- `dispenseProduct()`
- `returnChange()`


### 2. `Inventory`
- Maintains the product catalog and quantity of each product.
- Uses a `ConcurrentHashMap<Product, Integer>` for thread safety in concurrent environments.

**Key Methods:**
- `addProduct(Product product, int quantity)`
- `removeProduct(Product product)`
- `updateQuantity(Product product, int quantity)`
- `getQuantity(Product product)`
- `isAvailable(Product product)`

**Why `ConcurrentHashMap`?**
- Ensures thread safety in multi-threaded environments (e.g., multiple users accessing the vending machine simultaneously).
- Prevents data inconsistencies in product stock management.


### 3. `Product`
- Represents an item sold by the vending machine.

**Attributes:**
- `name`: Name of the product
- `price`: Price of the product (in double)


### 4. `Coin` (Enum)
- Represents supported coin denominations and their values.

```java
public enum Coin {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10);
}
```

### 🔁 State Pattern Overview

| **State**           | **Description**                                               |
|---------------------|---------------------------------------------------------------|
| `IdleState`         | Initial state. Waiting for user to select a product.          |
| `ReadyState`        | Product selected. Waiting for user to insert coins.           |
| `DispenseState`     | Sufficient payment made. Dispensing product.                  |
| `ReturnChangeState` | Returns any remaining change and resets the system.           |

