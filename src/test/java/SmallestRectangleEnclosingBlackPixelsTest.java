import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmallestRectangleEnclosingBlackPixelsTest {
    SmallestRectangleEnclosingBlackPixels solution = new SmallestRectangleEnclosingBlackPixels();

    @Test
    public void testExample1() {
        assertEquals(6, solution.minArea(new char[][]{new char[]{'0','0','1','0'},new char[]{'0','1','1','0'},new char[]{'0','1','0','0'}}, 0, 2));
    }

    @Test
    public void testExample2() {
        assertEquals(1, solution.minArea(new char[][]{new char[]{'1'}}, 0, 0));
    }
}
