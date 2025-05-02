
/*
    Using an interface for VendingMachineState is a classic implementation
    of the State Design Pattern, and it serves a clear purpose in making the
    VendingMachine behavior extensible and maintainable.

    Example:
    When the machine is in IdleState, calling insertCoin() might transition
    it to ReadyState.
    When it's in DispenseState, calling insertCoin() might just print
    “Please collect the product first.”
    Each of these behaviors is implemented differently, but thanks to the
    interface, the machine doesn’t care which state it's in — it just calls
    the method.

 */
public interface VendingMachineState {

    void returnChange();

    void selectProduct(Product product);

    void dispenseProduct();

    void insertCoin(Coin coin);
}
