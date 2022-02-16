import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumVacationDaysTest {
    MaximumVacationDays solution = new MaximumVacationDays();

    @Test
    public void testExample1() {
        assertEquals(12, solution.maxVacationDays(new int[][]{new int[]{0,1,1},new int[]{1,0,1},new int[]{1,1,0}}, new int[][]{new int[]{1,3,1},new int[]{6,0,3},new int[]{3,3,3}}));
    }

    @Test
    public void testExample2() {
        assertEquals(3, solution.maxVacationDays(new int[][]{new int[]{0,0,0},new int[]{0,0,0},new int[]{0,0,0}}, new int[][]{new int[]{1,1,1},new int[]{7,7,7},new int[]{7,7,7}}));
    }

    @Test
    public void testExample3() {
        assertEquals(21, solution.maxVacationDays(new int[][]{new int[]{0,1,1},new int[]{1,0,1},new int[]{1,1,0}}, new int[][]{new int[]{7,0,0},new int[]{0,7,0},new int[]{0,0,7}}));
    }
}
