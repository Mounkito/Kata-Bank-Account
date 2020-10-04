import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class AccountTest {

    @Test
    void an_new_account_created_have_0_money(){
        Account account = new Account();
        assertThat(account.getMoney()).isEqualTo(new Money(0));
    }

    @Test
    void should_deposits_10_on_my_account() {
        Account account = new Account();
        account.deposits(new Money(10));
        assertThat(account.getMoney()).isEqualTo(new Money(10));
    }
}
