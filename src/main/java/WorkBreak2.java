import java.util.ArrayList;
import java.util.List;

public class WorkBreak2 {
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

    List<List<Integer>> breaks;

    void findBreaks(String word) {
        breaks = new ArrayList<>(word.length());
        for(int i = 0; i < word.length(); ++i) breaks.add(new ArrayList<>());
        for(int suffixStart = word.length() - 1; suffixStart >= 0; --suffixStart) {
            int pos = suffixStart;
            TrieNode node = root;
            while(node != null) {
                if (node.wordEnd) {
                    if (pos == word.length() || breaks.get(pos) != null) {
                        breaks.get(suffixStart).add(pos);
                    }
                }
                if (pos == word.length()) break;
                int childIndex = word.charAt(pos) - 'a';
                node = node.children[childIndex];
                ++pos;
            }
        }
    }

    List<List<String>> sentences;

    void findSentences(String word, int pos) {
        for(int breakPos : breaks.get(pos)) {
            if (breakPos == word.length()) {
                sentences.get(pos).add(word.substring(pos));
            } else {
                if (sentences.get(breakPos).size() == 0) findSentences(word, breakPos);
                for(String sentence : sentences.get(breakPos)) {
                    sentences.get(pos).add(word.substring(pos, breakPos) + ' ' + sentence);
                }
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        for (String word : wordDict) {
            root.addWord(word, 0);
        }

        findBreaks(s);

        sentences = new ArrayList<>(s.length());
        for(int i = 0; i < s.length(); ++i) sentences.add(new ArrayList<>());
        findSentences(s, 0);

        return sentences.get(0);
    }
}
