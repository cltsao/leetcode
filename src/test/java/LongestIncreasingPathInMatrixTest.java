import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestIncreasingPathInMatrixTest {
    LongestIncreasingPathInMatrix solution = new LongestIncreasingPathInMatrix();

    @Test
    public void testExample1() {
        assertEquals(4, solution.longestIncreasingPath(new int[][] {new int[]{9,9,4},new int[]{6,6,8},new int[]{2,1,1}}));
    }

    @Test
    public void testExample2() {
        assertEquals(4, solution.longestIncreasingPath(new int[][] {new int[]{3,4,5},new int[]{3,2,6},new int[]{2,2,1}}));
    }

    @Test
    public void testExample3() {
        assertEquals(1, solution.longestIncreasingPath(new int[][] {new int[]{1}}));
    }

    @Test
    public void testExample4() {
        assertEquals(4, solution.longestIncreasingPath(new int[][] {new int[]{7,7,5},new int[]{2,4,6},new int[]{8,2,0}}));
    }

    @Test
    public void testExample5() {
        assertEquals(140, solution.longestIncreasingPath(new int[][] {new int[]{0,1,2,3,4,5,6,7,8,9},new int[]{19,18,17,16,15,14,13,12,11,10},new int[]{20,21,22,23,24,25,26,27,28,29},new int[]{39,38,37,36,35,34,33,32,31,30},new int[]{40,41,42,43,44,45,46,47,48,49},new int[]{59,58,57,56,55,54,53,52,51,50},new int[]{60,61,62,63,64,65,66,67,68,69},new int[]{79,78,77,76,75,74,73,72,71,70},new int[]{80,81,82,83,84,85,86,87,88,89},new int[]{99,98,97,96,95,94,93,92,91,90},new int[]{100,101,102,103,104,105,106,107,108,109},new int[]{119,118,117,116,115,114,113,112,111,110},new int[]{120,121,122,123,124,125,126,127,128,129},new int[]{139,138,137,136,135,134,133,132,131,130},new int[]{0,0,0,0,0,0,0,0,0,0}}));
    }
}
