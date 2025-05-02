import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
     1.If you only have a single VendingMachine instance in your application,
     and you don't plan to share the inventory across multiple vending machines
     or components, then you don't need to make Inventory a Singleton. In that case,
     it can be treated as a regular object created once inside the VendingMachine.

     2.ConcurrentHashMap ensures that multiple threads can safely read and write to
     the inventory without causing data corruption or inconsistencies.
 */
public class Inventory {

    private final Map<Product, Integer> products;

    public Inventory() {
        this.products = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public int getQuantity(Product product) {
        return products.getOrDefault(product, 0);
    }

    public void updateQuantity(Product product, int quantity) {
        products.put(product, quantity);
    }

    public boolean isAvailable(Product product) {
        return products.containsKey(product) && products.get(product)>0;
    }
}
