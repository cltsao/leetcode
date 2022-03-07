import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInRotatedSortedArrayTest {
    SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();

    @Test
    public void testExample1() {
        assertEquals(4, solution.search(new int[] {4,5,6,7,0,1,2}, 0));
    }

    @Test
    public void testExample2() {
        assertEquals(-1, solution.search(new int[] {4,5,6,7,0,1,2}, 3));
    }

    @Test
    public void testExample3() {
        assertEquals(-1, solution.search(new int[] {1}, 0));
    }

    @Test
    public void testExample4() {
        assertEquals(1, solution.search(new int[] {1,3}, 3));
    }

    @Test
    public void testExample5() {
        assertEquals(2, solution.search(new int[] {5,1,3}, 3));
    }

    @Test
    public void testExample6() {
        assertEquals(4, solution.search(new int[] {4,5,6,7,8,1,2,3}, 8));
    }
}
