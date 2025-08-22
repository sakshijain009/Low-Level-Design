// Abstraction for all birds
abstract class Bird {
    public abstract void eat();
}

// Interface for flying birds
interface Flyable {
    void fly();
}

// Flying bird
class Sparrow extends Bird implements Flyable {
    @Override
    public void eat() {
        System.out.println("Sparrow eats seeds.");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying high!");
    }
}

// Non-flying bird
class Ostrich extends Bird {
    @Override
    public void eat() {
        System.out.println("Ostrich eats plants and seeds.");
    }
}

// Example usage
public class LSPExample {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird ostrich = new Ostrich();

        sparrow.eat();
        ostrich.eat();

        // Safe substitution
        Flyable flyer = new Sparrow();
        flyer.fly();

        // Ostrich does not pretend to fly → LSP preserved
    }
}
