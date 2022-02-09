import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumNumberOfVisiblePointsTest {
    MaximumNumberOfVisiblePoints solution = new MaximumNumberOfVisiblePoints();

    @Test
    public void testExample1() {
        assertEquals(3, solution.visiblePoints(List.of(List.of(2,1),List.of(2,2),List.of(3,3)), 90, List.of(1, 1)));
    }

    @Test
    public void testExample2() {
        assertEquals(4, solution.visiblePoints(List.of(List.of(2,1),List.of(2,2),List.of(3,4),List.of(1,1)), 90, List.of(1, 1)));
    }

    @Test
    public void testExample3() {
        assertEquals(1, solution.visiblePoints(List.of(List.of(1,0),List.of(2,1)), 13, List.of(1, 1)));
    }

    @Test
    public void testExample4() {
        assertEquals(2, solution.visiblePoints(List.of(List.of(1,1),List.of(2,2),List.of(1,2),List.of(2,1)), 0, List.of(1,1)));
    }

    @Test
    public void testExample5() {
        assertEquals(5, solution.visiblePoints(List.of(List.of(41,7),List.of(22,94),List.of(90,53),List.of(94,54),List.of(58,50),List.of(51,96),List.of(87,88),List.of(55,98),List.of(65,62),List.of(36,47),List.of(91,61),List.of(15,41),List.of(31,94),List.of(82,80),List.of(42,73),List.of(79,6),List.of(45,4)), 17, List.of(6,84)));
    }
}
