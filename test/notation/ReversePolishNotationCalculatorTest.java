package notation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReversePolishNotationCalculatorTest {

    ReversePolishNotationCalculator calculator;
    String str;
    int result;
    int expected;


    @BeforeEach
    void beforeEach() {
        calculator = new ReversePolishNotationCalculator();
    }

    @Test
    public void shouldCalculateAddition() {
        str = "1 2 3 + +";
        int result = calculator.calculatePolishNotation(str);
        int expected = 6;

        assertEquals(expected, result, "ошибка выполнения суммы");
    }

    @Test
    public void shouldCalculateDistinction() {
        str = "1 2 3 - -";
        int result = calculator.calculatePolishNotation(str);
        int expected = 2;

        assertEquals(expected, result, "ошибка выполнения разницы");
    }

    @Test
    public void shouldCalculateMultiplication() {
        str = "1 2 4 * *";
        int result = calculator.calculatePolishNotation(str);
        int expected = 8;

        assertEquals(expected, result, "ошибка выполнения умножения");
    }

    @Test
    public void shouldCalculateWithNegativeNumbers() {
        str = "-1 2 4 5 * + -";
        int result = calculator.calculatePolishNotation(str);
        int expected = -23;

        assertEquals(expected, result, "ошибка выполнения операции с отрицательными числами");
    }

    @Test
    public void shouldCalculateWithMultipleSpaces() {
        str = "     -1     2   4    5     *  +     -   ";
        int result = calculator.calculatePolishNotation(str);
        int expected = -23;

        assertEquals(expected, result, "ошибка выполнения операции с множеством пробелов");
    }
    //ей, конец!
}
