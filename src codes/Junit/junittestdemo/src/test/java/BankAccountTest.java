import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import Junit.BankAccount;

public class BankAccountTest {

    BankAccount account = new BankAccount("ABC1234", 172.0);

    @Test
    void bankAccountFetch(){
        assertEquals("ABC1234", account.getBankAccountNumber());
    }

    @Test
    void bankBalanceFetch(){
        assertEquals(172.0, account.getBalance());
    }

    @Test
    void depositSuccess(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(700.0);
        });
        assertEquals("Depoist must be more than 0", ex.getMessage());
    }

    @Test
    void withDrawSuccess(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.withDraw(20.0);
        });
        assertEquals("Insufficient balance", ex.getMessage());
    }

    @Test
    void depositFail(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-200.0);
        });
        assertEquals("Depoist must be more than 0", ex.getMessage());
    }

    @Test
    void withDrawFail(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.withDraw(200.0);
        });
        assertEquals("Insufficient balance", ex.getMessage());
    }
}