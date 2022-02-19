import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TilingRectangleWithTheFewestSquaresTest {
    TilingRectangleWithTheFewestSquares solution = new TilingRectangleWithTheFewestSquares();

    @Test
    public void testExample1() {
        assertEquals(3, solution.tilingRectangle(2, 3));
    }

    @Test
    public void testExample2() {
        assertEquals(5, solution.tilingRectangle(5, 8));
    }

    @Test
    public void testExample3() {
        assertEquals(6, solution.tilingRectangle(11, 13));
    }
}
