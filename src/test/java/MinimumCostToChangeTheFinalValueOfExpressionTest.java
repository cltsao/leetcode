import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumCostToChangeTheFinalValueOfExpressionTest {
    MinimumCostToChangeTheFinalValueOfExpression solution = new MinimumCostToChangeTheFinalValueOfExpression();

    @Test
    public void testExample1() {
        assertEquals(1, solution.minOperationsToFlip("1&(0|1)"));
    }

    @Test
    public void testExample2() {
        assertEquals(3, solution.minOperationsToFlip("(0&0)&(0&0&0)"));
    }

    @Test
    public void testExample3() {
        assertEquals(1, solution.minOperationsToFlip("(0|(1|0&1))"));
    }

    @Test
    public void testExample4() {
        assertEquals(2, solution.minOperationsToFlip("(((0)&1&((0&0))))"));
    }
}
