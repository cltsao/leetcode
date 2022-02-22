import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumPointsYouCanObtainFromCardsTest {
    MaximumPointsYouCanObtainFromCards solution = new MaximumPointsYouCanObtainFromCards();

    @Test
    public void testExample1() {
        assertEquals(12, solution.maxScore(new int[]{1,2,3,4,5,6,1}, 3));
    }

    @Test
    public void testExample2() {
        assertEquals(4, solution.maxScore(new int[]{2,2,2}, 2));
    }

    @Test
    public void testExample3() {
        assertEquals(55, solution.maxScore(new int[]{9,7,7,9,7,7,9}, 7));
    }

    @Test
    public void testExample4() {
        assertEquals(1, solution.maxScore(new int[]{1,1000,1}, 1));
    }
}
