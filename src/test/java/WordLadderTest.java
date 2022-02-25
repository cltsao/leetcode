import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordLadderTest {
    WordLadder solution = new WordLadder();

    @Test
    public void testExample1() {
        assertEquals(5, solution.ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log","cog")));
    }

    @Test
    public void testExample2() {
        assertEquals(0, solution.ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log")));
    }
}
