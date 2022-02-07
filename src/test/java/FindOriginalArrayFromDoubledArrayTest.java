import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindOriginalArrayFromDoubledArrayTest {
    FindOriginalArrayFromDoubledArray foafda = new FindOriginalArrayFromDoubledArray();

    @Test
    public void testExample1() {
        assertArrayEquals(new int[] {1,3,4}, foafda.findOriginalArray(new int[] {1,3,4,2,6,8}));
    }

    @Test
    public void testExample2() {
        assertArrayEquals(new int[] {}, foafda.findOriginalArray(new int[] {6,3,0,1}));
    }

    @Test
    public void testExample3() {
        assertArrayEquals(new int[] {}, foafda.findOriginalArray(new int[] {1}));
    }

    @Test
    public void testExample4() {
        assertArrayEquals(new int[] {0, 0}, foafda.findOriginalArray(new int[] {0,0,0,0}));
    }
}
