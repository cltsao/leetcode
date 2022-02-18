import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumTimeDifferenceTest {
    MinimumTimeDifference solution = new MinimumTimeDifference();

    @Test
    public void testExample1() {
        assertEquals(1, solution.findMinDifference(List.of("23:59","00:00")));
    }

    @Test
    public void testExample2() {
        assertEquals(0, solution.findMinDifference(List.of("00:00","23:59","00:00")));
    }
}
