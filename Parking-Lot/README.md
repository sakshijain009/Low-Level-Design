# Parking Lot System Design

## Functional Requirements
- The system shall support a **multi-level parking lot**, where each level contains a configurable number of parking spots.
- The system shall support multiple **vehicle types**, including **Car**, **Bike**, and **Bus**.
- Each **ParkingSpot** shall be configured to support a specific **VehicleType**.
- The system shall automatically **assign an appropriate parking spot** to a vehicle upon entry and **release the spot** upon exit.
- The system shall maintain **real-time tracking of spot availability** and provide this information to users.
- The system shall support **multiple entry and exit points** and handle **concurrent access** safely.

---

## System Design Components

### 1. `ParkingLot` (Singleton)
- Central controller managing the parking system.
- Ensures a **single instance** via the Singleton pattern.
- Maintains a list of `Level` objects.
- Provides methods to **park** and **unpark** vehicles.

### 2. `Level`
- Represents a **floor** in the parking structure.
- Contains a list of `ParkingSpot` objects.
- Responsible for **allocating and releasing spots** on that level.

### 3. `ParkingSpot`
- Represents an individual parking space.
- Stores:
  - Spot number
  - Supported `VehicleType`
  - Currently parked vehicle
- Uses `synchronized` methods to ensure **thread safety**.

### 4. `Vehicle` (Abstract Class)
- Abstract base class for all vehicle types.
- Contains common attributes such as license plate and vehicle type.
- Extended by:
  - `Car`
  - `Bike`
  - `Bus`

### 5. `VehicleType` (Enum)
- Enumerates supported vehicle categories:
  - `CAR`
  - `BIKE`
  - `BUS`

### 6. Concurrency Handling
- Uses the `synchronized` keyword for thread-safe operations.
- Designed to support **concurrent entry and exit** operations.

---

## Design Patterns Used

- **Singleton Pattern**: Guarantees a single instance of the `ParkingLot`.
- **Factory Pattern** *(optional)*: Can be used to dynamically create `Car`, `Bike`, or `Bus` objects.
- **Observer Pattern** *(optional)*: For notifying users or systems about real-time spot availability.

---

## `Main` Class
- Demonstrates usage:
  - Parking and unparking of `Car`, `Bike`, and `Bus`.
  - Real-time availability checking.
  - Simulation of **concurrent access** using threads.
