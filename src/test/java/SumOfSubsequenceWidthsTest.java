import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfSubsequenceWidthsTest {
    SumOfSubsequenceWidths solution = new SumOfSubsequenceWidths();

    @Test
    public void testExample1() {
        assertEquals(6, solution.sumSubseqWidths(new int[] {2,1,3}));
    }

    @Test
    public void testExample2() {
        assertEquals(0, solution.sumSubseqWidths(new int[] {2}));
    }

    @Test
    public void testExample3() {
        assertEquals(857876214, solution.sumSubseqWidths(new int[] {5,69,89,92,31,16,25,45,63,40,16,56,24,40,75,82,40,12,50,62,92,44,67,38,92,22,91,24,26,21,100,42,23,56,64,43,95,76,84,79,89,4,16,94,16,77,92,9,30,13}));
    }
}
