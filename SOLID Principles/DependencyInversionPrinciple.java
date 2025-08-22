// Abstraction
interface Switchable {
    void turnOn();
    void turnOff();
}

// Low-level modules
class LightBulb implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("LightBulb ON");
    }

    @Override
    public void turnOff() {
        System.out.println("LightBulb OFF");
    }
}

class Fan implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Fan ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan OFF");
    }
}

// High-level module
class Switch {
    private Switchable device; // ✅ depends on abstraction

    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate(boolean on) {
        if (on) device.turnOn();
        else device.turnOff();
    }
}

// Demo
public class Main {
    public static void main(String[] args) {
        Switchable bulb = new LightBulb();
        Switch bulbSwitch = new Switch(bulb);
        bulbSwitch.operate(true);
        bulbSwitch.operate(false);

        Switchable fan = new Fan();
        Switch fanSwitch = new Switch(fan);
        fanSwitch.operate(true);
        fanSwitch.operate(false);
    }
}
