
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // Add products to the inventory
        Product coke = new Product("Coke", 27);
        Product pepsi = new Product("Pepsi", 20);
        Product water = new Product("Water", 20);

        vendingMachine.getInventory().addProduct(coke, 5);
        vendingMachine.getInventory().addProduct(pepsi, 3);
        vendingMachine.getInventory().addProduct(water, 2);

        // Select a product
        vendingMachine.selectProduct(coke);

        // Insert coins
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.FIVE);


        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();

        // Select another product
        vendingMachine.selectProduct(pepsi);

        // Insert insufficient payment
        vendingMachine.insertCoin(Coin.TEN);

        // Try to dispense the product
        vendingMachine.dispenseProduct();

        // Insert more coins
        vendingMachine.insertCoin(Coin.ONE);
        vendingMachine.insertCoin(Coin.ONE);
        vendingMachine.insertCoin(Coin.TWENTY);
        vendingMachine.insertCoin(Coin.ONE);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();
    }
}