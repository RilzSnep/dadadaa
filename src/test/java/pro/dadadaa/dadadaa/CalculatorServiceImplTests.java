package pro.dadadaa.dadadaa;

import org.junit.jupiter.api.Test;
import pro.dadadaa.dadadaa.Service.CalculatorServiceImpl;
import pro.dadadaa.dadadaa.exeption.DivisionByZeroException;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceImplTests {
    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @Test
    void testPlus() {
        assertEquals("5 + 5 = 10", calculatorService.plus(5, 5));
    }

    @Test
    void testMinus() {
        assertEquals("5 - 5 = 0", calculatorService.plus(5, 5));
    }

    @Test
    void testMultiply() {
        assertEquals("5 * 5 = 25", calculatorService.plus(5, 5));
    }

    @Test
    void testDivide() {
        assertEquals("5 / 5 = 1", calculatorService.plus(5, 5));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(DivisionByZeroException.class, () -> calculatorService.divide(5, 0));
        assertEquals("Ошибка: деление на 0 запрещено!", exception.getMessage());
    }
}
