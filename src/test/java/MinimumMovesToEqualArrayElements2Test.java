import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumMovesToEqualArrayElements2Test {
    MinimumMovesToEqualArrayElements2 solution = new MinimumMovesToEqualArrayElements2();

    @Test
    public void testExample1() {
        assertEquals(2, solution.minMoves2(new int[] {1,2,3}));
    }

    @Test
    public void testExample2() {
        assertEquals(16, solution.minMoves2(new int[] {1,10,2,9}));
    }

    @Test
    public void testExample3() {
        assertEquals(14, solution.minMoves2(new int[] {1,0,0,8,6}));
    }
}
