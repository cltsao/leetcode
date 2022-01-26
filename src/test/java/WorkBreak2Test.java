import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkBreak2Test {
    WorkBreak2 wb2 = new WorkBreak2();

    @Test
    public void testExample1() {
        List<String> results = wb2.wordBreak("catsanddog", List.of("cat","cats","and","sand","dog"));
        assertThat(results).hasSameElementsAs(List.of("cats and dog","cat sand dog"));
    }

    @Test
    public void testExample2() {
        List<String> results = wb2.wordBreak("pineapplepenapple", List.of("apple","pen","applepen","pine","pineapple"));
        assertThat(results).hasSameElementsAs(List.of("pine apple pen apple","pineapple pen apple","pine applepen apple"));
    }

    @Test
    public void testExample3() {
        List<String> results = wb2.wordBreak("catsandog", List.of("cats","dog","sand","and","cat"));
        assertEquals(0, results.size());
    }
}
