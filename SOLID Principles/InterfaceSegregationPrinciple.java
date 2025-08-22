// Small, specific interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

// Classes implement only what they need
class Human implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Human is working.");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating.");
    }
}

class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working.");
    }
}
