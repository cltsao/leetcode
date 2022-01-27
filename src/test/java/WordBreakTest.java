import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordBreakTest {
    WordBreak wb = new WordBreak();

    @Test
    public void testExample1() {
        assertEquals(true, wb.wordBreak("leetcode", List.of("leet","code")));
    }

    @Test
    public void testExample2() {
        assertEquals(true, wb.wordBreak("applepenapple", List.of("apple","pen")));
    }

    @Test
    public void testExample3() {
        assertEquals(false, wb.wordBreak("catsandog", List.of("cats","dog","sand","and","cat")));
    }

    @Test
    public void testExample4() {
        assertEquals(false, wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }

    @Test
    public void testExample5() {
        assertEquals(false, wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                List.of("aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba")));
    }
}
