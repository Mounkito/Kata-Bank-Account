import exception.NotEnoughMoneyException;

public class Account {

    Money accountMoney;
    Statements history;
    private DateService dateService;

    public Account(DateService dateService) {
        this.dateService = dateService;
        this.accountMoney = new Money(0);
        this.history = new Statements();
    }

    public Account(DateService dateService , Money money) {
        this.accountMoney = money;
        this.dateService = dateService;
        this.history = new Statements();

    }

    public Money getAccountMoney() {
        return accountMoney;
    }

    public Money deposits(Money money) {
        history.add(
                new DepositStatement(
                        dateService.getDate(),
                        money,
                        accountMoney.add(money))
        );
        return accountMoney;
    }

    public Money withdraw(Money money) {
        if (money.isBiggerThan(this.accountMoney)) {
            throw new NotEnoughMoneyException();
        }
        return this.accountMoney.subtract(money);
    }

    public String showHistory() {
        return "Account" +
                history.show();
    }
}
