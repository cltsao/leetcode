import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutocompleteSystemTest {
    @Test
    public void testExample1() {
        AutocompleteSystem as = new AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"}, new int[]{5, 3, 2, 2});
        assertThat(as.input('i')).isEqualTo(List.of("i love you", "island", "i love leetcode"));
        assertThat(as.input(' ')).isEqualTo(List.of("i love you", "i love leetcode"));
        assertThat(as.input('a')).isEqualTo(List.of());
        assertThat(as.input('#')).isEqualTo(List.of());
    }

    @Test
    public void testExample2() {
        AutocompleteSystem as = new AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"}, new int[]{5, 3, 2, 2});
        assertThat(as.input('i')).isEqualTo(List.of("i love you", "island", "i love leetcode"));
        assertThat(as.input(' ')).isEqualTo(List.of("i love you", "i love leetcode"));
        assertThat(as.input('a')).isEqualTo(List.of());
        assertThat(as.input('#')).isEqualTo(List.of());
        assertThat(as.input('i')).isEqualTo(List.of("i love you", "island", "i love leetcode"));
        assertThat(as.input(' ')).isEqualTo(List.of("i love you","i love leetcode","i a"));
        assertThat(as.input('a')).isEqualTo(List.of("i a"));
        assertThat(as.input('#')).isEqualTo(List.of());
        assertThat(as.input('i')).isEqualTo(List.of("i love you","island","i a"));
        assertThat(as.input(' ')).isEqualTo(List.of("i love you","i a","i love leetcode"));
        assertThat(as.input('a')).isEqualTo(List.of("i a"));
        assertThat(as.input('#')).isEqualTo(List.of());
    }
}
