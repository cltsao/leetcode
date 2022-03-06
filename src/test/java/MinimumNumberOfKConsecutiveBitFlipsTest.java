import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumNumberOfKConsecutiveBitFlipsTest {
    MinimumNumberOfKConsecutiveBitFlips solution = new MinimumNumberOfKConsecutiveBitFlips();

    @Test
    public void testExample1() {
        assertEquals(2, solution.minKBitFlips(new int[] {0,1,0}, 1));
    }

    @Test
    public void testExample2() {
        assertEquals(-1, solution.minKBitFlips(new int[] {1,1,0}, 2));
    }

    @Test
    public void testExample3() {
        assertEquals(3, solution.minKBitFlips(new int[] {0,0,0,1,0,1,1,0}, 3));
    }
}
