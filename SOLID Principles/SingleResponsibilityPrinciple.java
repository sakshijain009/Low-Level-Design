class SRP {
    // Entity class: Represents user data only
    static class User {
        private String name;
        private String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() { return name; }
        public String getEmail() { return email; }
    }

    // Handles user persistence
    static class UserRepository {
        public void save(User user) {
            System.out.println("Saving user " + user.getName() + " to database...");
        }
    }

    // Handles user notifications
    static class EmailService {
        public void sendEmail(User user) {
            System.out.println("Sending email to " + user.getEmail() + "...");
        }
    }

    // Example usage
    public class SRPExample {
        public static void main(String[] args) {
            User user = new User("Sakshi", "sakshi@example.com");

            UserRepository repo = new UserRepository();
            EmailService emailService = new EmailService();

            repo.save(user);         // Only persistence
            emailService.sendEmail(user); // Only email responsibility
        }
    }

}
