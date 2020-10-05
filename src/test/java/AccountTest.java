import exception.NotEnoughMoneyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class AccountTest {

    private Account account;

    @BeforeEach
    void setup() {
        account = new Account(() -> LocalDate.of(2020, 10, 5));
    }

    @Test
    void an_new_account_created_have_0_money() {
        assertThat(account.getAccountMoney()).isEqualTo(new Money(0));
    }

    @Test
    void should_deposits_10_on_my_account() {
        account.deposits(new Money(10));
        assertThat(
                account.getAccountMoney())
                .isEqualTo(new Money(10)
                );
    }

    @Test
    void should_deposits_50_on_my_account() {
        account.deposits(new Money(50));
        assertThat(
                account.getAccountMoney())
                .isEqualTo(new Money(50)
                );
    }

    @Test
    void should_withdraw_10_on_my_account_which_there_is_10() {
        account = new Account(() -> LocalDate.of(2020, 10, 5), new Money(10));
        account.withdraw(new Money(10));
        assertThat(
                account.getAccountMoney())
                .isEqualTo(new Money(0));
    }

    @Test
    void should_withdraw_20_on_my_account_which_there_is_50_and_the_rest_is_30() {
        account = new Account(() -> LocalDate.of(2020, 10, 5), new Money(50));
        account.withdraw(new Money(20));
        assertThat(
                account.getAccountMoney())
                .isEqualTo(new Money(30));
    }

    @Test
    void should_throw_exception_when_withdraw_10_on_my_account_which_there_is_0() {
        assertThatThrownBy(
                () -> account.withdraw(new Money(10)))
                .isInstanceOf(NotEnoughMoneyException.class)
                .hasMessageContaining("Sorry this Account have not enough money");
    }

    @Test
    void should_deposits_10_twice_on_my_account() {
        account.deposits(new Money(10));
        account.deposits(new Money(10));
        assertThat(
                account.getAccountMoney())
                .isEqualTo(new Money(20)
                );
    }

    @Test
    void should_withdraw_5_twice_on_my_account_with_20() {
        account = new Account(() -> LocalDate.of(2020, 10, 5), new Money(20));
        account.withdraw(new Money(5));
        account.withdraw(new Money(5));
        assertThat(
                account.getAccountMoney())
                .isEqualTo(new Money(10)
                );
    }

    @Test
    void should_show_information_of_account_when_there_are_no_operations() {
        assertThat(
                account.showHistory())
                .isEqualTo("Account");
    }

    @Test
    void should_show_information_of_account_when_there_are_one_deposit_operation_of_10() {
        account.deposits(new Money(10));
        String newLine = System.getProperty("line.separator");
        assertThat(
                account.showHistory())
                .isEqualTo("Account"
                        + newLine
                        + "-- 2020-10-05 : +10 -- balance : 10 --");
    }

    @Test
    void should_show_information_of_account_when_there_are_one_deposit_operation_of_10_and_one_of_20() {
        account.deposits(new Money(10));
        account.deposits(new Money(20));
        String newLine = System.getProperty("line.separator");
        assertThat(
                account.showHistory())
                .isEqualTo("Account"
                        + newLine
                        + "-- 2020-10-05 : +10 -- balance : 10 --"
                        + newLine
                        + "-- 2020-10-05 : +20 -- balance : 30 --");
    }

    @Test
    void should_show_information_of_account_of_20_when_there_are_one_withdraw_of_10() {
        account =  new Account(() -> LocalDate.of(2020, 10, 5), new Money(20));
        account.withdraw(new Money(10));
        String newLine = System.getProperty("line.separator");
        assertThat(
                account.showHistory())
                .isEqualTo("Account"
                        + newLine
                        + "-- 2020-10-05 : -10 -- balance : 10 --");
    }

    @Test
    void should_show_information_of_account_with_two_deposit_and_one_withdraw() {
        account = new Account(() -> LocalDate.of(2020, 9, 6));
        account.deposits(new Money(100));
        account.withdraw(new Money(25));
        account.deposits(new Money(75));
        String newLine = System.getProperty("line.separator");
        assertThat(
                account.showHistory())
                .isEqualTo("Account"
                        + newLine
                        + "-- 2020-09-06 : +100 -- balance : 100 --"
                        + newLine
                        + "-- 2020-09-06 : -25 -- balance : 75 --"
                        + newLine
                        + "-- 2020-09-06 : +75 -- balance : 150 --"
                );
    }
}
