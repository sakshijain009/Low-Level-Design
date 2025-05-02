/*
    Immutability: Both name and price are final, making the object immutable
                    after creation. This improves thread safety and predictability.
    Constructor Initialization: Fields are set via the constructor and never change.
    Encapsulation: Fields are private, and access is controlled through getters.

 */
public class Product {

    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
