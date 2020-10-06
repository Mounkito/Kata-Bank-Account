package business;

import java.time.LocalDate;

class WithdrawStatement extends Statement {

    private static final String NEGATIVE_SYMBOL = "-";

    public WithdrawStatement(LocalDate date, Money money, Money balance) {
        super(date,money,balance);
    }

    @Override
    String show() {
        return NEGATIVE_SYMBOL + "- " + date.toString() + " : " + NEGATIVE_SYMBOL + operationMoney.show() + " " + NEGATIVE_SYMBOL + "- " + "balance : " + balance.show() + " " + NEGATIVE_SYMBOL + "-";
    }
}
