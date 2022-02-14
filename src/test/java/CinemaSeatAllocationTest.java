import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CinemaSeatAllocationTest {
    CinemaSeatAllocation solution = new CinemaSeatAllocation();

    @Test
    public void testExample1() {
        assertEquals(4, solution.maxNumberOfFamilies(3, new int[][]{new int[]{1,2},new int[]{1,3},new int[]{1,8},new int[]{2,6},new int[]{3,1},new int[]{3,10}}));
    }

    @Test
    public void testExample2() {
        assertEquals(2, solution.maxNumberOfFamilies(2, new int[][]{new int[]{2,1},new int[]{1,8},new int[]{2,6}}));
    }

    @Test
    public void testExample3() {
        assertEquals(4, solution.maxNumberOfFamilies(4, new int[][]{new int[]{4,3},new int[]{1,4},new int[]{4,6},new int[]{1,7}}));
    }
}
