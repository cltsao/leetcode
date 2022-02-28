import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestDuplicateSubstringTest {
    LongestDuplicateSubstring solution = new LongestDuplicateSubstring();

    @Test
    public void testExample1() {
        assertEquals("ana", solution.longestDupSubstring("banana"));
    }

    @Test
    public void testExample2() {
        assertEquals("", solution.longestDupSubstring("abcd"));
    }
}
