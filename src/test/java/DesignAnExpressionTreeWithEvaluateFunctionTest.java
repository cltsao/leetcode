import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DesignAnExpressionTreeWithEvaluateFunctionTest {
    DesignAnExpressionTreeWithEvaluateFunction solution = new DesignAnExpressionTreeWithEvaluateFunction();

    @Test
    public void testExample1() {
        assertEquals(2, solution.buildTree(new String[] {"3","4","+","2","*","7","/"}).evaluate());
    }

    @Test
    public void testExample2() {
        assertEquals(-16, solution.buildTree(new String[] {"4","5","2","7","+","-","*"}).evaluate());
    }
}
