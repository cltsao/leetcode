import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumLengthOfSubarrayWithPositiveProductTest {
    MaximumLengthOfSubarrayWithPositiveProduct solution = new MaximumLengthOfSubarrayWithPositiveProduct();

    @Test
    public void testExample1() {
        assertEquals(4, solution.getMaxLen(new int[] {1,-2,-3,4}));
    }

    @Test
    public void testExample2() {
        assertEquals(3, solution.getMaxLen(new int[] {0,1,-2,-3,-4}));
    }

    @Test
    public void testExample3() {
        assertEquals(2, solution.getMaxLen(new int[] {-1,-2,-3,0,1}));
    }
}
