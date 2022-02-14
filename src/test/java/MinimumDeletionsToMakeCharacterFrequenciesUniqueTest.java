import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumDeletionsToMakeCharacterFrequenciesUniqueTest {
    MinimumDeletionsToMakeCharacterFrequenciesUnique solution = new MinimumDeletionsToMakeCharacterFrequenciesUnique();

    @Test
    public void testExample1() {
        assertEquals(0, solution.minDeletions("aab"));
    }

    @Test
    public void testExample2() {
        assertEquals(2, solution.minDeletions("aaabbbcc"));
    }

    @Test
    public void testExample3() {
        assertEquals(2, solution.minDeletions("ceabaacb"));
    }
}
