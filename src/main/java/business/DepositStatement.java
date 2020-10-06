package business;

import java.time.LocalDate;

class DepositStatement extends Statement {

    private static final String POSITIVE_SYMBOL = "+";

    public DepositStatement(LocalDate date, Money money, Money balance) {
        super(date, money , balance);
    }

    @Override
    String show() {
        return "-- " + date.toString() + " : " + POSITIVE_SYMBOL + operationMoney.show() + " -- " + "balance : " + balance.show() + " --";
    }
}
