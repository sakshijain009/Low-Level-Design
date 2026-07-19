# 🃏 Deck of Cards - Object-Oriented Design (Java)

## Overview

This project is a Java implementation of a standard **52-card deck** following **Object-Oriented Design (OOD)** principles. It demonstrates clean class design, encapsulation, and the use of enums to model real-world entities such as cards, suits, and players.

The application supports deck creation, shuffling, drawing cards, and distributing cards among multiple players.


## Features

- Create a standard **52-card deck**
- Support for **4 suits**
  - ♣ Clubs
  - ♦ Diamonds
  - ♥ Hearts
  - ♠ Spades
- Support for **13 ranks**
  - Ace through King
- Automatically assigns card color
  - **Red:** Hearts, Diamonds
  - **Black:** Clubs, Spades
- Shuffle the deck
- Draw (pop) the top card
- Distribute cards equally among players
- Display each player's hand


## Project Structure

```text
src/
├── Card.java
├── Deck.java
├── Player.java
├── Suit.java
├── Rank.java
├── Color.java
└── Main.java
```


## Class Design

### Card

Represents an individual playing card.

**Attributes**
- Suit
- Rank
- Color


### Deck

Represents a deck of playing cards.

**Responsibilities**
- Create a standard deck
- Shuffle cards
- Draw the top card
- Track remaining cards
- Distribute cards among players


### Player

Represents a player in the game.

**Responsibilities**
- Maintain player's hand
- Receive cards
- Display cards


### Enums

The project uses Java enums for type safety and readability.

- `Suit`
- `Rank`
- `Color`


## Usage

### Shuffle the Deck

```java
deck.shuffle();
```

### Draw the Top Card

```java
Card card = deck.popCard();
```

### Distribute Cards

```java
deck.distribute(players, 5);
```

---

## Sample Output

```text
Alice's Cards:
KING of HEARTS
THREE of CLUBS
TEN of SPADES
...

Bob's Cards:
ACE of DIAMONDS
FIVE of HEARTS
...

Remaining cards = 32

Top card = JACK of CLUBS
```


## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Create Deck | O(52) ≈ O(1) |
| Shuffle | O(n) |
| Draw Top Card (`ArrayList`) | O(n) |
| Distribute Cards | O(players × cardsPerPlayer) |

> **Optimization:** Using `ArrayDeque<Card>` instead of `ArrayList` makes drawing the top card an **O(1)** operation.


## OOP Concepts Demonstrated

- Encapsulation
- Abstraction
- Composition
- Single Responsibility Principle (SRP)
- Type Safety using Enums
- Modular and Extensible Design


## Future Enhancements

- Add Joker cards
- Implement card games (Poker, Blackjack, Rummy, etc.)
- Introduce `Dealer` and `Game` classes
- Support multiple decks
- Add custom shuffle algorithms
- Write unit tests using JUnit


## Technologies Used

- Java
- Java Collections Framework
- Object-Oriented Programming (OOP)


## Author

This project was developed as a demonstration of **Object-Oriented Design (OOD)** and **Low-Level Design (LLD)** concepts in Java, making it suitable for interview preparation and learning clean software design.
