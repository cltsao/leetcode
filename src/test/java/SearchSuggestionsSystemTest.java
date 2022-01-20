import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchSuggestionsSystemTest {
    SearchSuggestionsSystem sss = new SearchSuggestionsSystem();

    @Test
    public void testExample1() {
        List<List<String>> allSuggestions = sss.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
        assertThat(allSuggestions.get(0)).hasSameElementsAs(List.of("mobile","moneypot","monitor"));
        assertThat(allSuggestions.get(1)).hasSameElementsAs(List.of("mobile","moneypot","monitor"));
        assertThat(allSuggestions.get(2)).hasSameElementsAs(List.of("mouse","mousepad"));
        assertThat(allSuggestions.get(3)).hasSameElementsAs(List.of("mouse","mousepad"));
        assertThat(allSuggestions.get(4)).hasSameElementsAs(List.of("mouse","mousepad"));
    }

    @Test
    public void testExample2() {
        List<List<String>> allSuggestions = sss.suggestedProducts(new String[]{"havana"}, "havana");
        assertThat(allSuggestions.get(0)).hasSameElementsAs(List.of("havana"));
        assertThat(allSuggestions.get(1)).hasSameElementsAs(List.of("havana"));
        assertThat(allSuggestions.get(2)).hasSameElementsAs(List.of("havana"));
        assertThat(allSuggestions.get(3)).hasSameElementsAs(List.of("havana"));
        assertThat(allSuggestions.get(4)).hasSameElementsAs(List.of("havana"));
        assertThat(allSuggestions.get(5)).hasSameElementsAs(List.of("havana"));
    }

    @Test
    public void testExample3() {
        List<List<String>> allSuggestions = sss.suggestedProducts(new String[]{"bags","baggage","banner","box","cloths"}, "bags");
        assertThat(allSuggestions.get(0)).hasSameElementsAs(List.of("baggage","bags","banner"));
        assertThat(allSuggestions.get(1)).hasSameElementsAs(List.of("baggage","bags","banner"));
        assertThat(allSuggestions.get(2)).hasSameElementsAs(List.of("baggage","bags"));
        assertThat(allSuggestions.get(3)).hasSameElementsAs(List.of("bags"));
    }

    @Test
    public void testNoMatch() {
        List<List<String>> allSuggestions = sss.suggestedProducts(new String[]{"havana"}, "tatiana");
        assertThat(allSuggestions.get(0)).hasSameElementsAs(List.of());
        assertThat(allSuggestions.get(1)).hasSameElementsAs(List.of());
        assertThat(allSuggestions.get(2)).hasSameElementsAs(List.of());
        assertThat(allSuggestions.get(3)).hasSameElementsAs(List.of());
        assertThat(allSuggestions.get(4)).hasSameElementsAs(List.of());
        assertThat(allSuggestions.get(5)).hasSameElementsAs(List.of());
    }
}
