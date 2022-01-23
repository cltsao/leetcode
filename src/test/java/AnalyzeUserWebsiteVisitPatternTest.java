import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AnalyzeUserWebsiteVisitPatternTest {
    AnalyzeUserWebsiteVisitPattern auwvp = new AnalyzeUserWebsiteVisitPattern();

    @Test
    public void testExample1() {
        List<String> pattern = auwvp.mostVisitedPattern(new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"});
        assertThat(pattern).hasSameElementsAs(List.of("home", "about", "career"));
    }

    @Test
    public void testExample2() {
        List<String> pattern = auwvp.mostVisitedPattern(new String[]{"ua", "ua", "ua", "ub", "ub", "ub"}, new int[]{1, 2, 3, 4, 5, 6}, new String[]{"a", "b", "a", "a", "b", "c"});
        assertThat(pattern).hasSameElementsAs(List.of("a","b","a"));
    }

    @Test
    public void testExample3() {
        List<String> pattern = auwvp.mostVisitedPattern(new String[]{"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"}, new int[]{527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930}, new String[]{"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"});
        assertThat(pattern).hasSameElementsAs(List.of("hibympufi","hibympufi","yljmntrclw"));
    }
}
