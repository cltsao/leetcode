public class WordFilter {
    static final char separator = '#';

    class TrieNode {
        TrieNode[] children;
        int largestIndex = -1;
    }

    TrieNode root;

    private int charToIndex(char c) {
        if (c == separator) return 26;
        return c - 'a';
    }

    private void addWord(String word, int pos, int wordIndex) {
        TrieNode node = root;
        while(pos < word.length()) {
            if (node.children == null)
                node.children = new TrieNode[27];
            int childIndex = charToIndex(word.charAt(pos));
            if (node.children[childIndex] == null)
                node.children[childIndex] = new TrieNode();
            node = node.children[childIndex];
            node.largestIndex = wordIndex;  // Words are added with increasing index
            ++pos;
        }
    }

    public WordFilter(String[] words) {
        root = new TrieNode();
        // Prepend every suffix with the word, and add the string into trie
        for(int index = 0; index < words.length; ++index) {
            String word = words[index];
            String combinedWord = word + separator + word;
            for(int i = 0; i < word.length(); ++i) {
                addWord(combinedWord, i, index);
            }
        }
    }

    public int f(String prefix, String suffix) {
        String search = suffix + separator + prefix;
        TrieNode node = root;
        for(char c : search.toCharArray()) {
            int childIndex = charToIndex(c);
            if (node.children == null || node.children[childIndex] == null)
                return -1;
            node = node.children[childIndex];
        }
        return node.largestIndex;
    }
}
