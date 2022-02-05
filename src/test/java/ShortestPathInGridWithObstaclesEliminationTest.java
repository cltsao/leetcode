import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestPathInGridWithObstaclesEliminationTest {
    ShortestPathInGridWithObstaclesElimination spigwoe = new ShortestPathInGridWithObstaclesElimination();

    @Test
    public void testExample1() {
        assertEquals(6, spigwoe.shortestPath(new int[][] {new int[]{0,0,0},new int[]{1,1,0},new int[]{0,0,0},new int[]{0,1,1},new int[]{0,0,0}}, 1));
    }

    @Test
    public void testExample2() {
        assertEquals(-1, spigwoe.shortestPath(new int[][] {new int[]{0,1,1},new int[]{1,1,1},new int[]{1,0,0}}, 1));
    }
}
