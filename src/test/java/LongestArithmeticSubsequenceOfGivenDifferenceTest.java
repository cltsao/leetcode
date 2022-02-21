import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestArithmeticSubsequenceOfGivenDifferenceTest {
    LongestArithmeticSubsequenceOfGivenDifference solution = new LongestArithmeticSubsequenceOfGivenDifference();

    @Test
    public void testExample1() {
        assertEquals(4, solution.longestSubsequence(new int[] {1,2,3,4}, 1));
    }

    @Test
    public void testExample2() {
        assertEquals(1, solution.longestSubsequence(new int[] {1,3,5,7}, 1));
    }

    @Test
    public void testExample3() {
        assertEquals(4, solution.longestSubsequence(new int[] {1,5,7,8,5,3,4,2,1}, -2));
    }
}
