import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveAllOnesWithRowAndColumnFlipsTest {
    RemoveAllOnesWithRowAndColumnFlips solution = new RemoveAllOnesWithRowAndColumnFlips();

    @Test
    public void testExample1() {
        assertEquals(true, solution.removeOnes(new int[][] {new int[]{0,1,0},new int[]{1,0,1},new int[]{0,1,0}}));
    }

    @Test
    public void testExample2() {
        assertEquals(false, solution.removeOnes(new int[][] {new int[]{1,1,0},new int[]{0,0,0},new int[]{0,0,0}}));
    }

    @Test
    public void testExample3() {
        assertEquals(true, solution.removeOnes(new int[][] {new int[]{0}}));
    }

    @Test
    public void testExample4() {
        assertEquals(false, solution.removeOnes(new int[][] {new int[]{0,0},new int[]{0,1}}));
    }

    @Test
    public void testExample5() {
        assertEquals(true, solution.removeOnes(new int[][] {new int[]{1,0,1,0},new int[]{1,0,1,0}}));
    }
}
