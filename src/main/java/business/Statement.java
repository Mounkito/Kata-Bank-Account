package business;

import java.time.LocalDate;

abstract class Statement {

    protected LocalDate date;
    protected Money operationMoney;
    protected Money balance;

    public Statement(LocalDate date, Money operationMoney, Money balance) {
        this.date = date;
        this.operationMoney = operationMoney;
        this.balance = balance;
    }

    abstract String show();
}
