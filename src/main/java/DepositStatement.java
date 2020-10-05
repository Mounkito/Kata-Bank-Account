import java.time.LocalDate;

public class DepositStatement extends Statement {
    public DepositStatement(LocalDate date, Money money, Money balance) {
        super(date, money , balance);
    }

    @Override
    String show() {
        return "-- " + date.toString() + " : +" + money.show() + " -- " + "balance : " + balance.show() + " --";
    }
}
