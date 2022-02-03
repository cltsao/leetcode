import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumSwapsToGroupAllOnesTogetherTest {
    MinimumSwapsToGroupAllOnesTogether mstgaot = new MinimumSwapsToGroupAllOnesTogether();

    @Test
    public void testExampel1() {
        assertEquals(1, mstgaot.minSwaps(new int[] {1,0,1,0,1}));
    }

    @Test
    public void testExampel2() {
        assertEquals(0, mstgaot.minSwaps(new int[] {0,0,0,1,0}));
    }

    @Test
    public void testExampel3() {
        assertEquals(3, mstgaot.minSwaps(new int[] {1,0,1,0,1,0,0,1,1,0,1}));
    }
}
