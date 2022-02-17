import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AngleBetweenHandsOfClockTest {
    AngleBetweenHandsOfClock solution = new AngleBetweenHandsOfClock();

    @Test
    public void testExample1() {
        assertEquals(165, solution.angleClock(12, 30));
    }

    @Test
    public void testExample2() {
        assertEquals(75, solution.angleClock(3, 30));
    }

    @Test
    public void testExample3() {
        assertEquals(7.5, solution.angleClock(3, 15));
    }
}
