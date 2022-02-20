import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AmountOfNewAreaPaintedEachDayTest {
    AmountOfNewAreaPaintedEachDay solution = new AmountOfNewAreaPaintedEachDay();

    @Test
    public void testExample1() {
        assertArrayEquals(new int[]{3,3,1}, solution.amountPainted(new int[][]{new int[]{1,4},new int[]{4,7},new int[]{5,8}}));
    }

    @Test
    public void testExample2() {
        assertArrayEquals(new int[]{3,3,1}, solution.amountPainted(new int[][]{new int[]{1,4},new int[]{5,8},new int[]{4,7}}));
    }

    @Test
    public void testExample3() {
        assertArrayEquals(new int[]{4,0}, solution.amountPainted(new int[][]{new int[]{1,5},new int[]{2,4}}));
    }
}
