import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WildcardMatchingTest {
    WildcardMatching solution = new WildcardMatching();

    @Test
    public void testExample1() {
        assertEquals(false, solution.isMatch("aa", "a"));
    }

    @Test
    public void testExample2() {
        assertEquals(true, solution.isMatch("aa", "*"));
    }

    @Test
    public void testExample3() {
        assertEquals(false, solution.isMatch("cb", "?a"));
    }

    @Test
    public void testExample4() {
        assertEquals(false, solution.isMatch("acdcb", "a*c?b"));
    }

    @Test
    public void testExample5() {
        assertEquals(true, solution.isMatch("", "******"));
    }

    @Test
    public void testExample6() {
        assertEquals(false, solution.isMatch("", "?"));
    }

    @Test
    public void testExample7() {
        assertEquals(false, solution.isMatch("b", "?*?"));
    }

    @Test
    public void testExample8() {
        assertEquals(false, solution.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }

    @Test
    public void testExample9() {
        assertEquals(true, solution.isMatch("aaaa", "***a"));
    }
}
