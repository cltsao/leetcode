import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BricksFallingWhenHitTest {
    BricksFallingWhenHit solution = new BricksFallingWhenHit();

    @Test
    public void testExample1() {
        assertArrayEquals(new int[]{2}, solution.hitBricks(new int[][]{new int[]{1,0,0,0},new int[]{1,1,1,0}}, new int[][]{new int[]{1,0}}));
    }

    @Test
    public void testExample2() {
        assertArrayEquals(new int[]{0, 0}, solution.hitBricks(new int[][]{new int[]{1,0,0,0},new int[]{1,1,0,0}}, new int[][]{new int[]{1,1},new int[]{1,0}}));
    }

    @Test
    public void testExample3() {
        assertArrayEquals(new int[]{0,0,1,0}, solution.hitBricks(new int[][]{new int[]{1,1,1},new int[]{0,1,0},new int[]{0,0,0}}, new int[][]{new int[]{0,2},new int[]{2,0},new int[]{0,1},new int[]{1,2}}));
    }
}
