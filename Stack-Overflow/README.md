# 🧠 StackOverflow Clone (Java)

A simplified, in-memory simulation of core Stack Overflow functionalities implemented in Java using Object-Oriented Design and basic concurrency features.


## 📌 Features

- 👤 **User Management**
  - Create users with reputation tracking
- ❓ **Question System**
  - Post questions with title, content, and tags
  - Search questions by keyword or tag
- ✅ **Answer System**
  - Post answers to questions
  - Mark an answer as accepted
- 💬 **Comments**
  - Add comments on both questions and answers
- 👍👎 **Voting**
  - Upvote and downvote questions/answers
  - Reputation updated accordingly
- 🔍 **Search**
  - Find questions by keyword, tag, or user
- 🔒 **Thread Safety**
  - Uses `ConcurrentHashMap` to ensure safe concurrent access


## 🧩 Design Patterns Used

| Pattern         | Description |
|----------------|-------------|
| **Strategy Pattern** | Used in voting logic and reputation calculation. The behavior of vote effects can be changed by replacing strategy implementation. |
| **Factory Pattern**  | Used indirectly through methods that encapsulate object creation like `createUser`, `askQuestion`, etc. |
| **Observer Pattern (Potential)** | Not implemented yet, but ideal for notifying users when their question is answered. |
| **Interface-Based Design** | `Commentable` interface enables both `Question` and `Answer` to be commented in a polymorphic way. |

