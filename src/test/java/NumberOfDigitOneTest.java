import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfDigitOneTest {
    NumberOfDigitOne solution = new NumberOfDigitOne();

    @Test
    public void testExample1() {
        assertEquals(6, solution.countDigitOne(13));
    }

    @Test
    public void testExample2() {
        assertEquals(0, solution.countDigitOne(0));
    }

    @Test
    public void testExample3() {
        assertEquals(21, solution.countDigitOne(100));
    }
}
