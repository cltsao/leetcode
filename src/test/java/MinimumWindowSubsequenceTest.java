import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumWindowSubsequenceTest {
    MinimumWindowSubsequence solution = new MinimumWindowSubsequence();

    @Test
    public void testExample1() {
        assertEquals("bcde", solution.minWindow("abcdebdde", "bde"));
    }

    @Test
    public void testExample2() {
        assertEquals("", solution.minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "u"));
    }

    @Test
    public void testExample3() {
        assertEquals("", solution.minWindow("aaa", "aaaaaaaa"));
    }
}
