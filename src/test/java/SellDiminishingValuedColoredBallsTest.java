import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SellDiminishingValuedColoredBallsTest {
    SellDiminishingValuedColoredBalls sdvcb = new SellDiminishingValuedColoredBalls();

    @Test
    public void testExample1() {
        assertEquals(14, sdvcb.maxProfit(new int[] {2,5}, 4));
    }

    @Test
    public void testExample2() {
        assertEquals(19, sdvcb.maxProfit(new int[] {3,5}, 6));
    }

    @Test
    public void testExample3() {
        assertEquals(21, sdvcb.maxProfit(new int[] {1000000000}, 1000000000));
    }
}
