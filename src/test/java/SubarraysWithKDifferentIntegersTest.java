import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubarraysWithKDifferentIntegersTest {
    SubarraysWithKDifferentIntegers solution = new SubarraysWithKDifferentIntegers();

    @Test
    public void testExample1() {
        assertEquals(7, solution.subarraysWithKDistinct(new int[] {1,2,1,2,3}, 2));
    }

    @Test
    public void testExample2() {
        assertEquals(3, solution.subarraysWithKDistinct(new int[] {1,2,1,3,4}, 3));
    }

    @Test
    public void testExample3() {
        assertEquals(8, solution.subarraysWithKDistinct(new int[] {2,1,1,1,2}, 1));
    }

    @Test
    public void testExample4() {
        assertEquals(149, solution.subarraysWithKDistinct(new int[] {27,27,43,28,11,20,1,4,49,18,37,31,31,7,3,31,50,6,50,46,4,13,31,49,15,52,25,31,35,4,11,50,40,1,49,14,46,16,11,16,39,26,13,4,37,39,46,27,49,39,49,50,37,9,30,45,51,47,18,49,24,24,46,47,18,46,52,47,50,4,39,22,50,40,3,52,24,50,38,30,14,12,1,5,52,44,3,49,45,37,40,35,50,50,23,32,1,2}, 20));
    }
}
