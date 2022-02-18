import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceCarTest {
    RaceCar solution = new RaceCar();

    @Test
    public void testExample1() {
        assertEquals(2, solution.racecar(3));
    }

    @Test
    public void testExample2() {
        assertEquals(5, solution.racecar(6));
    }

    @Test
    public void testExample3() {
        assertEquals(50, solution.racecar(5478));
    }
}
