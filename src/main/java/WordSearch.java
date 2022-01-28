import java.util.Arrays;

public class WordSearch {
    boolean[][] createBooleanBoard(char[][] board) {
        boolean[][] suffixBoard = new boolean[board.length][];
        for(int i = 0; i < board.length; ++i) {
            suffixBoard[i] = new boolean[board[i].length];
            Arrays.fill(suffixBoard[i], false);
        }
        return suffixBoard;
    }

    boolean[][] visited;

    boolean check(char[][] board, int i, int j, String word, int pos) {
        if (visited[i][j]) return false;
        if (board[i][j] != word.charAt(pos)) return false;
        if (pos == word.length() - 1) return true;
        visited[i][j] = true;
        if (i > 0 && check(board, i - 1, j, word, pos + 1)) return true;
        if (i < board.length - 1 && check(board, i + 1, j, word, pos + 1)) return true;
        if (j > 0 && check(board, i, j - 1, word, pos + 1)) return true;
        if (j < board[i].length - 1 && check(board, i, j + 1, word, pos + 1)) return true;
        visited[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        visited = createBooleanBoard(board);

        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; ++j) {
                if(check(board, i, j, word, 0)) return true;
            }
        }

        return false;
    }
}
