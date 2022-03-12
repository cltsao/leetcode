import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllGoodStringsTest {
    FindAllGoodStrings solution = new FindAllGoodStrings();

    @Test
    public void testKmp() {
        assertArrayEquals(new int[] {0, 1, 0, 1, 2, 3, 4, 5, 2}, solution.kmp("aabaabaaa"));
    }

    @Test
    public void testKmp2() {
        assertArrayEquals(new int[] {0, 0, 1, 2, 0, 1, 2, 3}, solution.kmp("ababcaba"));
    }

    @Test
    public void testEvilTransition() {
        int[][] E = solution.evilTransition("ababcaba");
        assertEquals(1, E[0][0]);
        assertEquals(2, E[1][1]);
        assertEquals(3, E[2][0]);
        assertEquals(1, E[3][0]);
        assertEquals(4, E[3][1]);
        assertEquals(3, E[4][0]);
        assertEquals(5, E[4][2]);
        assertEquals(6, E[5][0]);
        assertEquals(1, E[6][0]);
        assertEquals(7, E[6][1]);
    }

    @Test
    public void testExample1() {
        assertEquals(51, solution.findGoodStrings(2, "aa", "da", "b"));
    }

    @Test
    public void testExample2() {
        assertEquals(0, solution.findGoodStrings(8, "leetcode", "leetgoes", "leet"));
    }

    @Test
    public void testExample3() {
        assertEquals(2, solution.findGoodStrings(2, "gx", "gz", "x"));
    }
}
