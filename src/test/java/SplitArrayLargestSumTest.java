import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SplitArrayLargestSumTest {
    SplitArrayLargestSum solution = new SplitArrayLargestSum();

    @Test
    public void testExample1() {
        assertEquals(18, solution.splitArray(new int[] {7,2,5,10,8}, 2));
    }

    @Test
    public void testExample2() {
        assertEquals(9, solution.splitArray(new int[] {1,2,3,4,5}, 2));
    }

    @Test
    public void testExample3() {
        assertEquals(4, solution.splitArray(new int[] {1,4,4}, 3));
    }

    @Test
    public void testExample4() {
        assertEquals(15, solution.splitArray(new int[] {1,2,3,4,5}, 1));
    }
}
