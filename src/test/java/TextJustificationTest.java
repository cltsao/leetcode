import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TextJustificationTest {
    TextJustification tj = new TextJustification();

    @Test
    public void testExample1() {
        assertThat(List.of("This    is    an",
                "example  of text",
                "justification.  ")).hasSameElementsAs(tj.fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }

    @Test
    public void testExample2() {
        assertThat(List.of("What   must   be",
                "acknowledgment  ",
                "shall be        ")).hasSameElementsAs(tj.fullJustify(new String[] {"What","must","be","acknowledgment","shall","be"}, 16));
    }

    @Test
    public void testExample3() {
        assertThat(List.of("Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  ")).hasSameElementsAs(tj.fullJustify(new String[] {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));
    }
}
