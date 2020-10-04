public class Account {

    Money money;

    public Account() {
        this.money = new Money(0);
    }

    public Money getMoney() {
        return money;
    }

    public Money deposits(Money money) {
        return this.money = this.money.add(money);
    }
}
