import java.time.LocalDate;

abstract class Statement {

    protected LocalDate date;
    protected Money money;
    protected Money balance;

    public Statement(LocalDate date, Money money, Money balance) {
        this.date = date;
        this.money = money;
        this.balance = balance;
    }

    abstract String show();
}
