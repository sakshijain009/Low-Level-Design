# ⚡ Rate Limiter – Theory

## 1. What is a Rate Limiter?
A **Rate Limiter** is a mechanism used to **control how many requests a client can make** to a service within a given time window.  
It prevents abuse, ensures fair usage, and protects backend services from being overloaded.

## 2. Why do we need it?
Imagine we have millions of users calling an API:
- If a single user or attacker sends **too many requests per second**, it can **overload the server**.
- This can cause:
  - Increased response times ⏱
  - Server crashes 💥
  - Starvation of genuine users (they can’t access the system because a few users hog resources).
- ✅ A Rate Limiter protects the system by **allowing only a fixed number of requests in a defined time window**.

## 3. Real-world Examples
- **Login API**: limit to 5 attempts per minute → prevents brute-force attacks.  
- **Payment API**: limit to 10 payments/sec per user → protects banking systems.  
- **Public APIs (Twitter, GitHub, Google Maps)**: limit requests to prevent abuse of free tiers.  

## 4. Types of Rate Limiting Algorithms
1. **Fixed Window Counter**  
   - Keep a counter for each fixed time window (e.g., per second).
   - Simple, but has *burst problem*: all users may send requests at window boundaries.

2. **Sliding Window Log / Queue (Interview-friendly)**  
   - Store timestamps of each request in a queue.
   - Allow if queue size < max limit.
   - Smooths out bursts → more accurate.

3. **Token Bucket**  
   - Bucket refills tokens at a fixed rate.
   - Each request consumes a token.
   - Allows short bursts while keeping average rate limited.
   - Most commonly used in production.

4. **Leaky Bucket**  
   - Requests go into a queue (bucket).
   - Bucket leaks (processes) at a constant rate.
   - Smooths traffic into fixed flow.

## 📌 Core Entities
1. **RateLimiter**
   - Configurable per user or API.
   - Attributes:
     - `maxRequests` → maximum allowed requests
     - `timeWindowMillis` → duration of sliding window
     - `userRequests` → Map<UserId, Queue of timestamps>
   - Methods:
     - `allowRequest(userId)` → returns true/false

2. **User Requests Queue**
   - Holds timestamps of recent requests for each user.
   - Old timestamps are removed when they fall outside the window.

## 🔄 Flow of Logic (Sliding Window with Queue)

1. **Request arrives** → call `allowRequest(userId)`  
2. Fetch or create queue for this `userId`.  
3. Remove timestamps older than `(now - timeWindowMillis)`.  
4. If queue size `< maxRequests`:  
   - Add current timestamp  
   - ✅ Allow request  
5. Else:  
   - ❌ Deny request  
