import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LongestHappyStringTest {
    LongestHappyString solution = new LongestHappyString();

    boolean confirm(String str, int a, int b, int c) {
        if (str.contains("aaa") || str.contains("bbb") || str.contains("ccc")) return false;
        for(char ch : str.toCharArray()) {
            switch(ch) {
                case 'a':
                    --a;
                    break;
                case 'b':
                    --b;
                    break;
                case 'c':
                    --c;
                    break;
                default:
                    return false;
            }
        }
        return a >= 0 && b >= 0 && c >= 0;
    }

    @Test
    public void testExample1() {
        String result = solution.longestDiverseString(1, 1, 7);
        assertTrue(confirm(result, 1, 1, 7));
        assertEquals(8, result.length());
    }

    @Test
    public void testExample2() {
        String result = solution.longestDiverseString(7, 1, 0);
        assertTrue(confirm(result, 7, 1, 0));
        assertEquals(5, result.length());
    }
}
