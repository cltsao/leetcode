import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergedIntervalsTest {
    MergeIntervals mi = new MergeIntervals();

    @Test
    public void testExample1() {
        int[][] result = mi.merge(new int[][]{new int[]{1,3}, new int[]{2,6}, new int[]{8,10}, new int[]{15,18}});
        assertArrayEquals(new int[][]{new int[]{1,6}, new int[]{8,10}, new int[]{15,18}}, result);
    }

    @Test
    public void testExample2() {
        int[][] result = mi.merge(new int[][]{new int[]{1,4}, new int[]{4,5}});
        assertArrayEquals(new int[][]{new int[]{1,5}}, result);
    }
}
