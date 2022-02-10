import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluateReversePolishNotationTest {
    EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

    @Test
    public void testExample1() {
        assertEquals(9, solution.evalRPN(new String[] {"2","1","+","3","*"}));
    }

    @Test
    public void testExample2() {
        assertEquals(6, solution.evalRPN(new String[] {"4","13","5","/","+"}));
    }

    @Test
    public void testExample3() {
        assertEquals(22, solution.evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
