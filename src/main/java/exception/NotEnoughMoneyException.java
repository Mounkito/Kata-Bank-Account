package exception;

public class NotEnoughMoneyException extends RuntimeException{

    public NotEnoughMoneyException() {
        super("Sorry this Account have not enough money");
    }
}
