import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumNumberOfPointsWithCostTest {
    MaximumNumberOfPointsWithCost mnopwc = new MaximumNumberOfPointsWithCost();

    @Test
    public void testExample1() {
        assertEquals(9, mnopwc.maxPoints(new int[][]{new int[]{1,2,3},new int[]{1,5,1},new int[]{3,1,1}}));
    }

    @Test
    public void testExample2() {
        assertEquals(11, mnopwc.maxPoints(new int[][]{new int[]{1,5},new int[]{2,3},new int[]{4,2}}));
    }

    @Test
    public void testExample3() {
        assertEquals(10, mnopwc.maxPoints(new int[][]{new int[]{10}}));
    }

    @Test
    public void testExample4() {
        assertEquals(15, mnopwc.maxPoints(new int[][]{new int[]{0,3,0,4,2},new int[]{5,4,2,4,1},new int[]{5,0,0,5,1},new int[]{2,0,1,0,3}}));
    }
}
