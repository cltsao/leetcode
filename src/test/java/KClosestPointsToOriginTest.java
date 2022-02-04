import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class KClosestPointsToOriginTest {
    KClosestPointsToOrigin kcpto = new KClosestPointsToOrigin();

    @Test
    public void testExample1() {
        assertArrayEquals(new int[][] {new int[]{-2,2}}, kcpto.kClosest(new int[][]{new int[]{1,3},new int[]{-2,2}}, 1));
    }

    @Test
    public void testExample2() {
        assertArrayEquals(new int[][] {new int[]{3,3},new int[]{-2,4}}, kcpto.kClosest(new int[][]{new int[]{3,3},new int[]{5,-1},new int[]{-2,4}}, 2));
    }
}
