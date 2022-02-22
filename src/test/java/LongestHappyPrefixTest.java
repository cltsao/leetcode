import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestHappyPrefixTest {
    LongestHappyPrefix solution = new LongestHappyPrefix();

    @Test
    public void testExample1() {
        assertEquals("l", solution.longestPrefix("level"));
    }

    @Test
    public void testExample2() {
        assertEquals("abab", solution.longestPrefix("ababab"));
    }

    @Test
    public void testExample3() {
        assertEquals("b", solution.longestPrefix("babbb"));
    }

    @Test
    public void testExample4() {
        assertEquals("ac", solution.longestPrefix("acccbaaacccbaac"));
    }

    @Test
    public void testExample5() {
        assertEquals("ccabcbbacbcbbac", solution.longestPrefix("ccabcbbacbcbbacccabaabcccabcbbacbcbbac"));
    }
}
