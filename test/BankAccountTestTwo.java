import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;

public class BankAccountTestTwo {

    @Test
    public void shouldNotBeBlockedWhenCreated() {
        BankAccountTwo account = new BankAccountTwo("a", "b");
        assertFalse(account.isBlocked());
    }

    @Test
    public void shouldReturnZeroAmountAfterActivation() {
        BankAccountTwo account = new BankAccountTwo("a", "b");
        account.activate("wqer");
        assertEquals(new Integer(0), account.getAmount());
        assertEquals("RUB", account.getCurrency());
    }


    @Test
    public void shouldBeBlockedAfterBlockIsCalled() {
        BankAccountTwo account = new BankAccountTwo("a", "b");
        account.block();
        assertTrue(account.isBlocked());
    }

    @Test
    public void shouldReturnFirstNameThenSecondName() {
        BankAccountTwo account = new BankAccountTwo("a", "b");
        String[] nameData = new String[] {"a", "b"};
        String[] bankNameData = account.getFullName();
        assertArrayEquals(nameData, bankNameData);
    }

    @Test
    public void shouldReturnNullAmountWhenNotActive() {
        final IllegalStateException exception = assertThrows(
                // класс ошибки
                IllegalStateException.class,

                // создание и переопределение экземпляра класса Executable
                new Executable() {
                    @Override
                    public void execute() {
                        BankAccountTwo account = new BankAccountTwo("a", "b");
                        account.getAmount();
                        String currency = account.getCurrency();
                        assertNull(currency);


                        // здесь блок кода, который хотим проверить
                        // при делении на 0 ожидаем ArithmeticException

                    }
                });
    }
}
