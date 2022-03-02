import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringWithoutAAAOrBBBTest {
    StringWithoutAAAOrBBB solution = new StringWithoutAAAOrBBB();

    @Test
    public void testExample1() {
        String result = solution.strWithout3a3b(1, 2);
        assertFalse(result.contains("aaa"));
        assertFalse(result.contains("bbb"));
    }

    @Test
    public void testExample2() {
        String result = solution.strWithout3a3b(4, 1);
        assertFalse(result.contains("aaa"));
        assertFalse(result.contains("bbb"));
    }
}
