public class Account {

    Money value;

    public Account() {
        this.value = new Money(0);
    }

    public Money getValue() {
        return value;
    }
}
