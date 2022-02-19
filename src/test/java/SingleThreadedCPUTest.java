import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SingleThreadedCPUTest {
    SingleThreadedCPU solution = new SingleThreadedCPU();

    @Test
    public void testExample1() {
        assertArrayEquals(new int[] {0,2,3,1}, solution.getOrder(new int[][]{new int[]{1,2},new int[]{2,4},new int[]{3,2},new int[]{4,1}}));
    }

    @Test
    public void testExample2() {
        assertArrayEquals(new int[] {4,3,2,0,1}, solution.getOrder(new int[][]{new int[]{7,10},new int[]{7,12},new int[]{7,5},new int[]{7,4},new int[]{7,2}}));
    }

    @Test
    public void testExample3() {
        assertArrayEquals(new int[] {14,5,12,3,0,13,10,11,9,6,4,15,8,1,17,2,7,16}, solution.getOrder(new int[][]{new int[]{46,9},new int[]{46,42},new int[]{30,46},new int[]{30,13},new int[]{30,24},new int[]{30,5},new int[]{30,21},new int[]{29,46},new int[]{29,41},new int[]{29,18},new int[]{29,16},new int[]{29,17},new int[]{29,5},new int[]{22,15},new int[]{22,13},new int[]{22,25},new int[]{22,49},new int[]{22,44}}));
    }
}
