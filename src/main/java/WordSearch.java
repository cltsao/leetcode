public class WordSearch {
    boolean check(char[][] board, int i, int j, String word, int pos) {
        if (board[i][j] == '#') return false;
        if (board[i][j] != word.charAt(pos)) return false;
        if (pos == word.length() - 1) return true;
        char c = board[i][j];
        board[i][j] = '#';
        if (i > 0 && check(board, i - 1, j, word, pos + 1)) return true;
        if (i < board.length - 1 && check(board, i + 1, j, word, pos + 1)) return true;
        if (j > 0 && check(board, i, j - 1, word, pos + 1)) return true;
        if (j < board[i].length - 1 && check(board, i, j + 1, word, pos + 1)) return true;
        board[i][j] = c;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;

        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; ++j) {
                if(check(board, i, j, word, 0)) return true;
            }
        }

        return false;
    }
}
