import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SearchSuggestionsSystem {
    // Complexity analysis: N = number of products, P = max product name length, S = search word length
    // Trie: NP + SP
    // Compare each product and search word: N(P+S)

    public void insertProductByLexicographicalOrder(List<String> suggestions, String product, int maxSize) {
        int position = 0;
        while(position < suggestions.size() && product.compareTo(suggestions.get(position)) > 0) ++position;
        if (position < maxSize) suggestions.add(position, product);
        if (suggestions.size() > maxSize) suggestions.remove(maxSize);
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> allSuggestions = new ArrayList<>();
        while(allSuggestions.size() < searchWord.length())
            allSuggestions.add(new ArrayList<>());

        for(String product : products) {
            for(int index = 0; index < Math.min(product.length(), searchWord.length()); ++index) {
                if (product.charAt(index) == searchWord.charAt(index)) {
                    insertProductByLexicographicalOrder(allSuggestions.get(index), product, 3);
                } else {
                    break;
                }
            }
        }

        return allSuggestions;
    }
}
