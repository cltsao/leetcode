import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwapAdjacentInLRStringTest {
    SwapAdjacentInLRString solution = new SwapAdjacentInLRString();

    @Test
    public void testExample1() {
        assertEquals(true, solution.canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }

    @Test
    public void testExample2() {
        assertEquals(false, solution.canTransform("X", "L"));
    }

    @Test
    public void testExample3() {
        assertEquals(false, solution.canTransform("RXX", "RXL"));
    }

    @Test
    public void testExample4() {
        assertEquals(false, solution.canTransform("LXXLXRLXXL", "XLLXRXLXLX"));
    }

    @Test
    public void testExample5() {
        assertEquals(false, solution.canTransform("RL", "LR"));
    }
}
