import java.time.LocalDate;

abstract class statement {

    protected LocalDate date;
    protected Money money;
    protected Money balance;

    public statement(LocalDate date, Money money, Money balance) {
        this.date = date;
        this.money = money;
        this.balance = balance;
    }

    abstract String show();
}
