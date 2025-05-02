public class ReturnChangeState implements VendingMachineState{

    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void returnChange() {
        if (vendingMachine.getTotalPayment() > vendingMachine.getSelectedProduct().getPrice()) {
            int change = (vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().getPrice());
            System.out.println("Change returned: $" + change);
        } else {
            System.out.println("No change to return.");
        }

        vendingMachine.resetTotalPayment();
        vendingMachine.resetSelectedProduct();
        vendingMachine.setVendingMachineState(vendingMachine.getIdleState());
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product already dispensed. Please collect the change.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please collect the change first.");
    }
}
