import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrangePrinterTest {
    StrangePrinter solution = new StrangePrinter();

    @Test
    public void testExample1() {
        assertEquals(2, solution.strangePrinter("aaabbb"));
    }

    @Test
    public void testExample2() {
        assertEquals(2, solution.strangePrinter("aba"));
    }

    @Test
    public void testExample3() {
        assertEquals(19, solution.strangePrinter("baacdddaaddaaaaccbddbcabdaabdbbcdcbbbacbddcabcaaa"));
    }
}
