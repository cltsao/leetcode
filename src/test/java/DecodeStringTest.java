import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecodeStringTest {
    DecodeString solution = new DecodeString();

    @Test
    public void testExample1() {
        assertEquals("aaabcbc", solution.decodeString("3[a]2[bc]"));
    }

    @Test
    public void testExample2() {
        assertEquals("accaccacc", solution.decodeString("3[a2[c]]"));
    }

    @Test
    public void testExample3() {
        assertEquals("abcabccdcdcdef", solution.decodeString("2[abc]3[cd]ef"));
    }
}
