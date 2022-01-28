import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrappingRainWaterTest {
    TrappingRainWater trw = new TrappingRainWater();

    @Test
    public void testExample1() {
        assertEquals(6, trw.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    @Test
    public void testExample2() {
        assertEquals(9, trw.trap(new int[]{4,2,0,3,2,5}));
    }
}
