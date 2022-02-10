import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestStringChainTest {
    LongestStringChain solution = new LongestStringChain();

    @Test
    public void testExample1() {
        assertEquals(4, solution.longestStrChain(new String[] {"a","b","ba","bca","bda","bdca"}));
    }

    @Test
    public void testExample2() {
        assertEquals(5, solution.longestStrChain(new String[] {"xbc","pcxbcf","xb","cxbc","pcxbc"}));
    }

    @Test
    public void testExample3() {
        assertEquals(1, solution.longestStrChain(new String[] {"abcd","dbqca"}));
    }
}
