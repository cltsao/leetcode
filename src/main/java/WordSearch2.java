import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;

        void addWord(String word, int pos) {
            if (pos == word.length()) this.word = word;
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

    List<String> foundWords;

    void visit(char[][] board, int row, int column, TrieNode node) {
        if (node.word != null) {
            foundWords.add(node.word);
            node.word = null; // avoid duplicate words
        }
        if (row < 0 || row >= board.length || column < 0 || column >= board[row].length) return;
        if (board[row][column] == '#') return;
        char c = board[row][column];
        int charIndex = c - 'a';
        if (node.children[charIndex] != null) {
            board[row][column] = '#';
            visit(board, row - 1, column, node.children[charIndex]);
            visit(board, row + 1, column, node.children[charIndex]);
            visit(board, row, column - 1, node.children[charIndex]);
            visit(board, row, column + 1, node.children[charIndex]);
        }
        board[row][column] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for(String word : words) {
            root.addWord(word, 0);
        }

        foundWords = new ArrayList<>();

        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; ++j) {
                visit(board, i, j, root);
            }
        }

        return foundWords;
    }
}
