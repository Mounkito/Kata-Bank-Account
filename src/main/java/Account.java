public class Account {

    Money money;

    public Account() {
        this.money = new Money(0);
    }

    public Account(Money money) {
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }

    public Money deposits(Money money) {
        return this.money.add(money);
    }

    public Money withdraw(Money money) {
        return  this.money.subtract(money);
    }
}
