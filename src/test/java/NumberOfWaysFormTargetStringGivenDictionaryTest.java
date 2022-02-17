import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfWaysFormTargetStringGivenDictionaryTest {
    NumberOfWaysFormTargetStringGivenDictionary solution = new NumberOfWaysFormTargetStringGivenDictionary();

    @Test
    public void testExample1() {
        assertEquals(6, solution.numWays(new String[] {"acca","bbbb","caca"}, "aba"));
    }

    @Test
    public void testExample2() {
        assertEquals(4, solution.numWays(new String[] {"abba","baab"}, "bab"));
    }
}
