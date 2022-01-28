import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordSearchTest {
    WordSearch ws = new WordSearch();

    @Test
    public void testExample1() {
        assertEquals(true, ws.exist(new char[][] {new char[]{'A','B','C','E'},new char[]{'S','F','C','S'},new char[]{'A','D','E','E'}}, "ABCCED"));
    }

    @Test
    public void testExample2() {
        assertEquals(true, ws.exist(new char[][] {new char[]{'A','B','C','E'},new char[]{'S','F','C','S'},new char[]{'A','D','E','E'}}, "SEE"));
    }

    @Test
    public void testExample3() {
        assertEquals(false, ws.exist(new char[][] {new char[]{'A','B','C','E'},new char[]{'S','F','C','S'},new char[]{'A','D','E','E'}}, "ABCB"));
    }

    @Test
    public void testExample4() {
        assertEquals(true, ws.exist(new char[][] {new char[]{'A'}}, "A"));
    }
}
