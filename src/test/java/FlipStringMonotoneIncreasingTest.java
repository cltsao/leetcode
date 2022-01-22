import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlipStringMonotoneIncreasingTest {
    FlipStringMonotoneIncreasing fsmi = new FlipStringMonotoneIncreasing();

    @Test
    public void testExample1() {
        assertEquals(1, fsmi.minFlipsMonoIncr("00110"));
    }

    @Test
    public void testExample2() {
        assertEquals(2, fsmi.minFlipsMonoIncr("010110"));
    }

    @Test
    public void testExample3() {
        assertEquals(2, fsmi.minFlipsMonoIncr("00011000"));
    }
}
