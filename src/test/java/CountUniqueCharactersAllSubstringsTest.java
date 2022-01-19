import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountUniqueCharactersAllSubstringsTest {
    CountUniqueCharactersAllSubstrings cucas = new CountUniqueCharactersAllSubstrings();

    @Test
    public void testSimpleStrings() {
        assertEquals(10, cucas.uniqueLetterString("ABC"));
        assertEquals(8, cucas.uniqueLetterString("ABA"));
        assertEquals(92, cucas.uniqueLetterString("LEETCODE"));
    }
}
