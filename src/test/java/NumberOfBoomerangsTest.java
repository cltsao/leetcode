import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfBoomerangsTest {
    NumberOfBoomerangs solution = new NumberOfBoomerangs();

    @Test
    public void testExample1() {
        assertEquals(2, solution.numberOfBoomerangs(new int[][]{new int[]{0,0},new int[]{1,0},new int[]{2,0}}));
    }

    @Test
    public void testExample2() {
        assertEquals(2, solution.numberOfBoomerangs(new int[][]{new int[]{1,1},new int[]{2,2},new int[]{3,3}}));
    }

    @Test
    public void testExample3() {
        assertEquals(0, solution.numberOfBoomerangs(new int[][]{new int[]{1,1}}));
    }

    @Test
    public void testExample4() {
        assertEquals(20, solution.numberOfBoomerangs(new int[][]{new int[]{0,0},new int[]{1,0},new int[]{-1,0},new int[]{0,1},new int[]{0,-1}}));
    }
}
