import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordsInStringTest {
    ReverseWordsInString solution = new ReverseWordsInString();

    @Test
    public void testExample1() {
        assertEquals("blue is sky the", solution.reverseWords("the sky is blue"));
    }

    @Test
    public void testExample2() {
        assertEquals("world hello", solution.reverseWords("  hello world  "));
    }

    @Test
    public void testExample3() {
        assertEquals("example good a", solution.reverseWords("a good   example"));
    }
}
