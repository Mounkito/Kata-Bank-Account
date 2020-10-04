import java.util.Objects;

public class Money {
    private int value;

    public Money(int i) {
        value = i;
    }

    public Money add(Money money) {
        return new Money(value + money.value );
    }

    public Money subtract(Money money) {
        return new Money(value - money.value );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
