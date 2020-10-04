import exception.NotEnoughMoneyException;

public class Account {

    Money accountMoney;

    public Account() {
        this.accountMoney = new Money(0);
    }

    public Account(Money money) {
        this.accountMoney = money;
    }

    public Money getAccountMoney() {
        return accountMoney;
    }

    public Money deposits(Money money) {
        return this.accountMoney.add(money);
    }

    public Money withdraw(Money money) {
        if(money.isBiggerThan(this.accountMoney)){
            throw new NotEnoughMoneyException();
        }
        return this.accountMoney.subtract(money);
    }

    public String showHistory() {
        return "Account";
    }
}
