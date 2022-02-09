import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentAttendanceRecord2Test {
    StudentAttendanceRecord2 solution = new StudentAttendanceRecord2();

    @Test
    public void testExample1() {
        assertEquals(8, solution.checkRecord(2));
    }

    @Test
    public void testExample2() {
        assertEquals(3, solution.checkRecord(1));
    }

    @Test
    public void testExample3() {
        assertEquals(183236316, solution.checkRecord(10101));
    }
}
