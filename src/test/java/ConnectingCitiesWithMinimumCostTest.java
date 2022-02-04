import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectingCitiesWithMinimumCostTest {
    ConnectingCitiesWithMinimumCost ccwmc = new ConnectingCitiesWithMinimumCost();

    @Test
    public void testExample1() {
        assertEquals(6, ccwmc.minimumCost(3, new int[][]{new int[]{1,2,5},new int[]{1,3,6},new int[]{2,3,1}}));
    }

    @Test
    public void testExample2() {
        assertEquals(-1, ccwmc.minimumCost(4, new int[][]{new int[]{1,2,3},new int[]{3,4,4}}));
    }

    @Test
    public void testExample3() {
        assertEquals(6, ccwmc.minimumCost(4, new int[][]{new int[]{1,2,1},new int[]{1,3,2},new int[]{3,4,4},new int[]{1,4,3}}));
    }
}
