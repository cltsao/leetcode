import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrixTest {
    MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix solution = new MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix();

    @Test
    public void testExample1() {
        assertEquals(3, solution.minFlips(new int[][]{new int[]{0,0},new int[]{0,1}}));
    }

    @Test
    public void testExample2() {
        assertEquals(0, solution.minFlips(new int[][]{new int[]{0}}));
    }

    @Test
    public void testExample3() {
        assertEquals(-1, solution.minFlips(new int[][]{new int[]{1,0,0},new int[]{1,0,0}}));
    }
}
