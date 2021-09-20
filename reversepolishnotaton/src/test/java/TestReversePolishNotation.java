import junit.framework.TestCase;

import java.math.BigDecimal;

public class TestReversePolishNotation extends TestCase {

    public void testAddition() {
        BigDecimal result = ComputeRPN.compute("5 3 +");
        assertEquals(BigDecimal.valueOf(8.00).setScale(2, BigDecimal.ROUND_HALF_UP), result);
    }

    public void testAdditionDouble() {
        BigDecimal result = ComputeRPN.compute("5.1 3.3 +");
        assertEquals(BigDecimal.valueOf(8.40).setScale(2, BigDecimal.ROUND_HALF_UP), result);
    }

    public void testAdditionNegativeNumbers() {
        BigDecimal result = ComputeRPN.compute("5 -3 +");
        assertEquals(BigDecimal.valueOf(2.00).setScale(2, BigDecimal.ROUND_HALF_UP), result);
    }

    public void testSubtraction() {
        BigDecimal result = ComputeRPN.compute("5 3 -");
        assertEquals(BigDecimal.valueOf(2.00).setScale(2, BigDecimal.ROUND_HALF_UP), result);
    }

    public void testMultiplication() {
        BigDecimal result = ComputeRPN.compute("5 3 *");
        assertEquals(BigDecimal.valueOf(15.00).setScale(2, BigDecimal.ROUND_HALF_UP), result);
    }

    public void testMultiplicationWithZero() {
        BigDecimal result = ComputeRPN.compute("5 0 *");
        assertEquals(BigDecimal.valueOf(0.00).setScale(2, BigDecimal.ROUND_HALF_UP), result);
    }

    public void testDivision() {
        BigDecimal result = ComputeRPN.compute("15 3 /");
        assertEquals(BigDecimal.valueOf(5.00).setScale(2, BigDecimal.ROUND_HALF_UP), result);
    }
}
