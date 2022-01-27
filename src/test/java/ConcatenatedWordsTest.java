import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConcatenatedWordsTest {
    ConcatenatedWords cw = new ConcatenatedWords();

    @Test
    public void testExample1() {
        List<String> results = cw.findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"});
        assertThat(results).hasSameElementsAs(List.of("catsdogcats","dogcatsdog","ratcatdogcat"));
    }

    @Test
    public void testExample2() {
        List<String> results = cw.findAllConcatenatedWordsInADict(new String[]{"cat","dog","catdog"});
        assertThat(results).hasSameElementsAs(List.of("catdog"));
    }
}
