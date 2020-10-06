import exception.NegativeMoneyException;
import exception.NotEnoughMoneyException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    void should_not_create_money_with_negative_value() {
                assertThatThrownBy(
                        () -> new Money(-10))
                .isInstanceOf(NegativeMoneyException.class);
    }
}