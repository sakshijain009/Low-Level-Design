public class CircuitBreakerDemo {

    enum State {
        CLOSED, OPEN, HALF_OPEN
    }

    static class CircuitBreaker {
        private State state = State.CLOSED;
        private int failureCount = 0;
        private final int failureThreshold;
        private final long resetTimeout;   // cooldown time
        private long lastFailureTime = 0;

        public CircuitBreaker(int failureThreshold, long resetTimeout) {
            this.failureThreshold = failureThreshold;
            this.resetTimeout = resetTimeout;
        }

        public boolean allowRequest() {
            if (state == State.OPEN) {
                long now = System.currentTimeMillis();
                if (now - lastFailureTime > resetTimeout) {
                    state = State.HALF_OPEN;   // try again
                    return true;
                }
                return false; // still blocked
            }
            return true; // Closed or Half-Open
        }

        public void recordSuccess() {
            failureCount = 0;
            state = State.CLOSED;
        }

        public void recordFailure() {
            failureCount++;
            lastFailureTime = System.currentTimeMillis();
            if (failureCount >= failureThreshold) {
                state = State.OPEN;
            }
        }

        public State getState() {
            return state;
        }
    }

    // Mock external service
    static class ExternalService {
        private int callCount = 0;

        public String call() throws Exception {
            callCount++;
            if (callCount <= 4) { // fail first 4 calls
                throw new Exception("Service failure");
            }
            return "Success Response";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CircuitBreaker cb = new CircuitBreaker(3, 4000); // trip after 3 failures, 4s cooldown
        ExternalService service = new ExternalService();

        for (int i = 1; i <= 10; i++) {
            System.out.println("Request " + i + " | State: " + cb.getState());

            if (!cb.allowRequest()) {
                System.out.println(" -> Fallback: Service Unavailable (Circuit OPEN)");
                Thread.sleep(500);
                continue;
            }

            try {
                String response = service.call();
                System.out.println(" -> " + response);
                cb.recordSuccess();
            } catch (Exception e) {
                System.out.println(" -> " + e.getMessage());
                cb.recordFailure();
            }

            Thread.sleep(500); // simulate delay between requests
        }
    }
}
