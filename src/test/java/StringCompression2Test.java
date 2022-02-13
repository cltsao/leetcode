import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompression2Test {
    StringCompression2 solution = new StringCompression2();

    @Test
    public void testExample1() {
        assertEquals(4, solution.getLengthOfOptimalCompression("aaabcccd", 2));
    }

    @Test
    public void testExample2() {
        assertEquals(2, solution.getLengthOfOptimalCompression("aabbaa", 2));
    }

    @Test
    public void testExample3() {
        assertEquals(3, solution.getLengthOfOptimalCompression("aaaaaaaaaaa", 0));
    }

    @Test
    public void testExample4() {
        assertEquals(1, solution.getLengthOfOptimalCompression("abc", 2));
    }

    @Test
    public void testExample5() {
        assertEquals(3, solution.getLengthOfOptimalCompression("abbbbbbbbbba", 2));
    }

    @Test
    public void testExample6() {
        assertEquals(7, solution.getLengthOfOptimalCompression("bababbaba", 1));
    }
}
