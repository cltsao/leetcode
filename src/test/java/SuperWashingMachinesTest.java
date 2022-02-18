import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperWashingMachinesTest {
    SuperWashingMachines solution = new SuperWashingMachines();

    @Test
    public void testExample1() {
        assertEquals(3, solution.findMinMoves(new int[] {1,0,5}));
    }

    @Test
    public void testExample2() {
        assertEquals(2, solution.findMinMoves(new int[] {0,3,0}));
    }

    @Test
    public void testExample3() {
        assertEquals(-1, solution.findMinMoves(new int[] {0,2,0}));
    }
}
