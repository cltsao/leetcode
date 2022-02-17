import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOfTwoSortedArraysTest {
    MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

    @Test
    public void testExample1() {
        assertEquals(2.0, solution.findMedianSortedArrays(new int[] {1,3}, new int[] {2}));
    }

    @Test
    public void testExample2() {
        assertEquals(2.5, solution.findMedianSortedArrays(new int[] {1,2}, new int[] {3,4}));
    }
}
