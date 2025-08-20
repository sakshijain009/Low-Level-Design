import java.util.*;

public class RateLimiter {
    private final int maxRequests;          // Max allowed requests
    private final long timeWindowMillis;    // Time window (e.g. 1 sec)
    private final Map<String, Deque<Long>> userRequests; // Store per user

    public RateLimiter(int maxRequests, long timeWindowMillis) {
        this.maxRequests = maxRequests;
        this.timeWindowMillis = timeWindowMillis;
        this.userRequests = new HashMap<>();
    }

    public synchronized boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        userRequests.putIfAbsent(userId, new ArrayDeque<>());
        Deque<Long> requests = userRequests.get(userId);

        // Remove timestamps outside the time window
        while (!requests.isEmpty() && now - requests.peekFirst() >= timeWindowMillis) {
            requests.pollFirst();
        }

        // Check if within limit
        if (requests.size() < maxRequests) {
            requests.addLast(now); // Record this request
            return true;
        }
        return false; // Denied
    }

    // Demo
    public static void main(String[] args) throws InterruptedException {
        RateLimiter limiter = new RateLimiter(3, 1000); // Max 3 req/sec
        String user = "user1";

        for (int i = 1; i <= 6; i++) {
            boolean allowed = limiter.allowRequest(user);
            System.out.println("Request " + i + " -> " + (allowed ? "ALLOWED" : "DENIED"));
            Thread.sleep(200); // 200ms gap
        }
    }
}
