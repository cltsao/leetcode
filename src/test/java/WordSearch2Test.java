import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordSearch2Test {
    public WordSearch2 ws2 = new WordSearch2();

    @Test
    public void testExample1() {
        List<String> results = ws2.findWords(new char[][]{new char[]{'o','a','a','n'},new char[]{'e','t','a','e'},new char[]{'i','h','k','r'},new char[]{'i','f','l','v'}}, new String[] {"oath","pea","eat","rain"});
        assertThat(results).hasSameElementsAs(List.of("eat","oath"));
    }

    @Test
    public void testExample2() {
        List<String> results = ws2.findWords(new char[][]{new char[]{'a','b'},new char[]{'c','d'}}, new String[] {"abcb"});
        assertEquals(0, results.size());
    }

    @Test
    public void testExample3() {
        List<String> results = ws2.findWords(new char[][]{new char[]{'a'}}, new String[] {"a"});
        assertThat(results).hasSameElementsAs(List.of("a"));
    }
}
