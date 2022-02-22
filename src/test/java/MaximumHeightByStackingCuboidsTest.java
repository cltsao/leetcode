import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumHeightByStackingCuboidsTest {
    MaximumHeightByStackingCuboids solution = new MaximumHeightByStackingCuboids();

    @Test
    public void testExample1() {
        assertEquals(190, solution.maxHeight(new int[][]{new int[]{50,45,20},new int[]{95,37,53},new int[]{45,23,12}}));
    }

    @Test
    public void testExample2() {
        assertEquals(76, solution.maxHeight(new int[][]{new int[]{38,25,45},new int[]{76,35,3}}));
    }

    @Test
    public void testExample3() {
        assertEquals(102, solution.maxHeight(new int[][]{new int[]{7,11,17},new int[]{7,17,11},new int[]{11,7,17},new int[]{11,17,7},new int[]{17,7,11},new int[]{17,11,7}}));
    }
}
