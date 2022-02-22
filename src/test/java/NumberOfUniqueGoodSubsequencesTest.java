import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfUniqueGoodSubsequencesTest {
    NumberOfUniqueGoodSubsequences solution = new NumberOfUniqueGoodSubsequences();

    @Test
    public void testExample1() {
        assertEquals(2, solution.numberOfUniqueGoodSubsequences("001"));
    }

    @Test
    public void testExample2() {
        assertEquals(2, solution.numberOfUniqueGoodSubsequences("11"));
    }

    @Test
    public void testExample3() {
        assertEquals(5, solution.numberOfUniqueGoodSubsequences("101"));
    }
}
