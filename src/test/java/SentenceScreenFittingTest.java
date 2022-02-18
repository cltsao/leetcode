import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SentenceScreenFittingTest {
    SentenceScreenFitting solution = new SentenceScreenFitting();

    @Test
    public void testExample1() {
        assertEquals(1, solution.wordsTyping(new String[] {"hello","world"}, 2, 8));
    }

    @Test
    public void testExample2() {
        assertEquals(2, solution.wordsTyping(new String[] {"a", "bcd", "e"}, 3, 6));
    }

    @Test
    public void testExample3() {
        assertEquals(1, solution.wordsTyping(new String[] {"i","had","apple","pie"}, 4, 5));
    }

    @Test
    public void testExample4() {
        assertEquals(1, solution.wordsTyping(new String[] {"hello","leetcode"}, 1, 20));
    }

    @Test
    public void testExample5() {
        assertEquals(5, solution.wordsTyping(new String[] {"hello","leetcode"}, 5, 20));
    }

    @Test
    public void testExample6() {
        assertEquals(10, solution.wordsTyping(new String[] {"f","p","a"}, 8, 7));
    }

    @Test
    public void testExample7() {
        assertEquals(5293333, solution.wordsTyping(new String[] {"try","to","be","better"}, 10000, 9001));
    }

    @Test
    public void testExample8() {
        assertEquals(0, solution.wordsTyping(new String[] {"hello"}, 10000, 1));
    }

    @Test
    public void testExample9() {
        assertEquals(62500, solution.wordsTyping(new String[] {"hi","ho","ni","hao","la","night","leetcode","welcome","awesome","light"}, 10000, 333));
    }

    @Test
    public void testExample10() {
        assertEquals(1, solution.wordsTyping(new String[] {"a","b","c"}, 3, 1));
    }
}
