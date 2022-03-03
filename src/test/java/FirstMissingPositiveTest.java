import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstMissingPositiveTest {
    FirstMissingPositive solution = new FirstMissingPositive();

    @Test
    public void testExample1() {
        assertEquals(3, solution.firstMissingPositive(new int[] {1,2,0}));
    }

    @Test
    public void testExample2() {
        assertEquals(2, solution.firstMissingPositive(new int[] {3,4,-1,1}));
    }

    @Test
    public void testExample3() {
        assertEquals(1, solution.firstMissingPositive(new int[] {7,8,9,11,12}));
    }

    @Test
    public void testExample4() {
        assertEquals(3, solution.firstMissingPositive(new int[] {2,1}));
    }

    @Test
    public void testExample5() {
        assertEquals(2, solution.firstMissingPositive(new int[] {3,4,-1,1}));
    }
}
