import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOfDoubledPairsTest {
    ArrayOfDoubledPairs solution = new ArrayOfDoubledPairs();

    @Test
    public void testExample1() {
        assertEquals(false, solution.canReorderDoubled(new int[] {3,1,3,6}));
    }

    @Test
    public void testExample2() {
        assertEquals(false, solution.canReorderDoubled(new int[] {2,1,2,6}));
    }

    @Test
    public void testExample3() {
        assertEquals(true, solution.canReorderDoubled(new int[] {4,-2,2,-4}));
    }
}
