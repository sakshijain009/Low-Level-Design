public class VendingMachine {
    private static VendingMachine instance;
    private final Inventory inventory;
    private final IdleState idleState;
    private final ReadyState readyState;
    private final DispenseState dispenseState;
    private final ReturnChangeState returnChangeState;
    private VendingMachineState currentState;
    private Product selectedProduct;
    private int totalPayment;

    private VendingMachine() {
        this.inventory = new Inventory();
        this.idleState = new IdleState(this);
        this.readyState = new ReadyState(this);
        this.dispenseState = new DispenseState(this);
        this.returnChangeState = new ReturnChangeState(this);
        selectedProduct = null;
        totalPayment = 0;
        currentState = idleState;
    }

    //  Singleton instance
    public static synchronized VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    ReadyState getReadyState() {
        return readyState;
    }

    IdleState getIdleState() {
        return idleState;
    }

    DispenseState getDispenseState() {
        return dispenseState;
    }

    ReturnChangeState getReturnChangeState() {
        return returnChangeState;
    }

    Inventory getInventory() {
        return inventory;
    }

    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange() {
        currentState.returnChange();
    }

    void setVendingMachineState(VendingMachineState vendingMachineState) {
        currentState = vendingMachineState;
    }

    void setSelectedProduct(Product product) {
        selectedProduct = product;
    }

    Product getSelectedProduct() {
        return selectedProduct;
    }

    void resetSelectedProduct() {
        selectedProduct = null;
    }

    void resetTotalPayment() {
        totalPayment = 0;
    }

    void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }

    int getTotalPayment() {
        return totalPayment;
    }
}
