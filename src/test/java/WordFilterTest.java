import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordFilterTest {
    @Test
    public void testExample1() {
        WordFilter wordFilter = new WordFilter(new String[]{"apple"});
        assertEquals(0, wordFilter.f("a", "e"));
    }
}
