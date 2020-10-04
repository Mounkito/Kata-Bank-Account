import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class AccountTest {

    @Test
    void an_new_account_created_have_0_money(){
        Account account = new Account();
        assertThat(account.getValue()).isEqualTo(new Money(0));
    }
}
