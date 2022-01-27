import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatenatedWords {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean wordEnd;

        void addWord(String word, int pos) {
            if (pos == word.length()) wordEnd = true;
            else {
                int childIndex = word.charAt(pos) - 'a';
                if (children[childIndex] == null) {
                    children[childIndex] = new TrieNode();
                }
                children[childIndex].addWord(word, pos + 1);
            }
        }
    }

    TrieNode root;

    boolean findWord(String word) {
        boolean[] suffixFound = new boolean[word.length()];
        Arrays.fill(suffixFound, false);
        for(int suffixStart = word.length() - 1; suffixStart >= 0; --suffixStart) {
            int pos = suffixStart;
            TrieNode node = root;
            while(node != null) {
                if (node.wordEnd) {
                    // Exclude the case that this word match with itself
                    if (pos == word.length()) {
                      if (suffixStart != 0) {
                          suffixFound[suffixStart] = true;
                      }
                      break;
                    }
                    if (suffixFound[pos]) {
                        suffixFound[suffixStart] = true;
                        break;
                    }
                }
                if (pos == word.length()) break;
                int childIndex = word.charAt(pos) - 'a';
                node = node.children[childIndex];
                ++pos;
            }
        }
        return suffixFound[0];
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new TrieNode();
        for (String word : words) {
            root.addWord(word, 0);
        }

        List<String> concatenatedWords = new ArrayList<>();
        for (String word : words) {
            if (findWord(word)) {
                concatenatedWords.add(word);
            }
        }
        return concatenatedWords;
    }
}
