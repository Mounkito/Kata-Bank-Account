package business;

import exception.NotEnoughMoneyException;
import service.DateService;
import service.Printer;

public class Account {

    private Printer printer;
    private Money accountMoney;
    private Statements statements;
    private DateService dateService;

    public Account(DateService dateService) {
        this.dateService = dateService;
        this.accountMoney = new Money(0);
        this.statements = new Statements();
    }

    public Account(DateService dateService, Money money) {
        this.accountMoney = money;
        this.dateService = dateService;
        this.statements = new Statements();

    }

    public Account(DateService dateService, Printer printer) {
        this.printer = printer;
        this.dateService = dateService;
        this.statements = new Statements();
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

    public String showStatements() {
        if (printer != null)
            printer.print("business.Account");
        return "business.Account" +
                statements.show();
    }

}
