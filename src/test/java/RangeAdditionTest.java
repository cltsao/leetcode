import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RangeAdditionTest {
    RangeAddition ra = new RangeAddition();

    @Test
    public void testExample1() {
        int[] result = ra.getModifiedArray(5, new int[][]{new int[]{1,3,2}, new int[]{2,4,3}, new int[]{0,2,-2}});
        assertArrayEquals(new int[]{-2,0,3,5,3}, result);
    }

    @Test
    public void testExample2() {
        int[] result = ra.getModifiedArray(10, new int[][]{new int[]{2,4,6}, new int[]{5,6,8}, new int[]{1,9,-4}});
        assertArrayEquals(new int[]{0,-4,2,2,2,4,4,-4,-4,-4}, result);
    }
}
