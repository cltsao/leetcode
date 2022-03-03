import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class StreamChecker {
    class TrieNode {
        TrieNode[] children;
        boolean wordEnd;
        TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public StreamChecker(String[] words) {
        // Prune long words that have another word as its suffix
        Arrays.sort(words, Comparator.comparingInt(String::length));
        TrieNode reverseTrie = new TrieNode();
        root = new TrieNode();
        for(String word : words) {
            TrieNode node = reverseTrie;
            boolean foundSuffix = false;
            for(int i = word.length() - 1; i >= 0; --i) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
                if (node.wordEnd) {
                    foundSuffix = true;
                    break;
                }
            }
            node.wordEnd = true;
            if (foundSuffix) continue;

            node = root;
            for(char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.wordEnd = true;
        }
    }

    Set<TrieNode> matchedNodes = new HashSet<>();

    public boolean query(char letter) {
        boolean wordMatched = false;
        Set<TrieNode> nextNodes = new HashSet<>();
        matchedNodes.add(root);
        for(TrieNode node : matchedNodes) {
            if (node.children[letter - 'a'] != null) {
                if (node.children[letter - 'a'].wordEnd) wordMatched = true;
                nextNodes.add(node.children[letter - 'a']);
            }
        }
        matchedNodes = nextNodes;
        return wordMatched;
    }
}
