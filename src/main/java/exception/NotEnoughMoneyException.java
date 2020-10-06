package exception;

public class NotEnoughMoneyException extends RuntimeException{

    public NotEnoughMoneyException() {
        super("Sorry this business.Account have not enough money");
    }
}
