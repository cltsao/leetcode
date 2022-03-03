import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BurstBalloonsTest {
    BurstBalloons solution = new BurstBalloons();

    @Test
    public void testExample1() {
        assertEquals(167, solution.maxCoins(new int[] {3,1,5,8}));
    }

    @Test
    public void testExample2() {
        assertEquals(10, solution.maxCoins(new int[] {1,5}));
    }
}
