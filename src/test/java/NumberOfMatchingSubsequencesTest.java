import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfMatchingSubsequencesTest {
    NumberOfMatchingSubsequences solution = new NumberOfMatchingSubsequences();

    @Test
    public void testExample1() {
        assertEquals(3, solution.numMatchingSubseq("abcde", new String[] {"a","bb","acd","ace"}));
    }

    @Test
    public void testExample2() {
        assertEquals(2, solution.numMatchingSubseq("dsahjpjauf", new String[] {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
    }
}
