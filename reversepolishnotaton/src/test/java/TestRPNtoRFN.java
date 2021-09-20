import junit.framework.TestCase;

public class TestRPNtoRFN extends TestCase {

    public void testUnaryOperation() {
        String result = RPNtoRFN.process("1 ++");
        assertEquals("(1++)", result);
    }

    public void testBinaryOperation() {
        String result = RPNtoRFN.process("1 2 +");
        assertEquals("(1+2)", result);
    }

    public void testUnaryAndBinaryCombines() {
        String result = RPNtoRFN.process("1 2 ++ +");
        assertEquals("(1+(2++))", result);
    }

    public void testBinnaryOperationsCombines() {
        String result = RPNtoRFN.process("1 3 2 + -");
        assertEquals("(1-(3+2))", result);
    }

    public void testCombinationOfRPNExpressions() {
        String result = RPNtoRFN.process("5 ++ 1 2 + +");
        assertEquals("((5++)+(1+2))", result);
    }
}
