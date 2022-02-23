import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrappingRainWaterIITest {
    TrappingRainWaterII solution = new TrappingRainWaterII();

    @Test
    public void testExample1() {
        assertEquals(4, solution.trapRainWater(new int[][]{new int[]{1,4,3,1,3,2},new int[]{3,2,1,3,2,4},new int[]{2,3,3,2,3,1}}));
    }

    @Test
    public void testExample2() {
        assertEquals(10, solution.trapRainWater(new int[][]{new int[]{3,3,3,3,3},new int[]{3,2,2,2,3},new int[]{3,2,1,2,3},new int[]{3,2,2,2,3},new int[]{3,3,3,3,3}}));
    }

    @Test
    public void testExample3() {
        assertEquals(14, solution.trapRainWater(new int[][]{new int[]{12,13,1,12},new int[]{13,4,13,12},new int[]{13,8,10,12},new int[]{12,13,12,12},new int[]{13,13,13,13}}));
    }

    @Test
    public void testExample4() {
        assertEquals(3, solution.trapRainWater(new int[][]{new int[]{5,5,5,1},new int[]{5,1,1,5},new int[]{5,1,5,5},new int[]{5,2,5,8}}));
    }
}
