import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculator3Test {
    BasicCalculator3 solution = new BasicCalculator3();

    @Test
    public void testExample1() {
        assertEquals(2, solution.calculate("1+1"));
    }

    @Test
    public void testExample2() {
        assertEquals(4, solution.calculate("6-4/2"));
    }

    @Test
    public void testExample3() {
        assertEquals(21, solution.calculate("2*(5+5*2)/3+(6/2+8)"));
    }

    @Test
    public void testExample4() {
        assertEquals(-24, solution.calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}