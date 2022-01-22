import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheKthFactorTest {
    TheKthFactor tkf = new TheKthFactor();

    @Test
    public void testExample1() {
        assertEquals(3, tkf.kthFactor(12, 3));
    }

    @Test
    public void testExample2() {
        assertEquals(7, tkf.kthFactor(7, 2));
    }

    @Test
    public void testExample3() {
        assertEquals(-1, tkf.kthFactor(4, 4));
    }

    @Test
    public void testSquare() {
        assertEquals(6, tkf.kthFactor(36, 5));
        assertEquals(9, tkf.kthFactor(36, 6));
    }
}
