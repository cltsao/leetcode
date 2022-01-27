import java.util.Arrays;
import java.util.List;

public class WordBreak {
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
                    if (pos == word.length() || suffixFound[pos]) {
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

    public boolean wordBreak(String s, List<String> wordDict) {
        long startTime = System.nanoTime();
        root = new TrieNode();
        for (String word : wordDict) {
            if (!findWord(word))
                root.addWord(word, 0);
        }
        boolean result = findWord(s);
        System.out.println("Execution time: " + (System.nanoTime() - startTime) / 1e6 + " ms");
        return result;
    }
}
