package exception;

public class NegativeMoneyException extends RuntimeException {
    public NegativeMoneyException() {
        super("The value of the money must be positive");
    }
}
