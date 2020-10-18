package business;

import exception.NotEnoughMoneyException;
import service.DateService;
import service.Printer;

public class Account {

    private Printer printer;
    private Money accountMoney;
    private Statements statements;
    private DateService dateService;

    public Account(DateService dateService, Printer printer) {
        this.printer = printer;
        this.dateService = dateService;
        this.statements = new Statements();
        this.accountMoney = new Money(0);
    }

    public Account(DateService dateService, Money money, Printer printer) {
        this.printer = printer;
        this.dateService = dateService;
        this.statements = new Statements();
        this.accountMoney = money;
    }

    public Money getAccountMoney() {
        return accountMoney;
    }

    public Money deposits(Money money) {
        statements.add(
                new DepositStatement(
                        dateService.getDate(),
                        money,
                        accountMoney.add(money))
        );
        return accountMoney;
    }

    public Money withdraw(Money money) {
        if (money.isBiggerThan(accountMoney)) {
            throw new NotEnoughMoneyException();
        }
        statements.add(
                new WithdrawStatement(
                        dateService.getDate(),
                        money,
                        accountMoney.subtract(money)));
        return this.accountMoney;
    }

    public void showStatements() {
            printer.print("Account" + statements.show());
    }

}
