public class ReadyState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected. Please make payment.");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Coin inserted: " + coin);
        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make payment first.");
    }

    @Override
    public void returnChange() {
        System.out.println("Please make payment first.");
    }

    private void checkPaymentStatus() {
        if (vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice()) {
            vendingMachine.setVendingMachineState(vendingMachine.getDispenseState());
        }
    }
}
