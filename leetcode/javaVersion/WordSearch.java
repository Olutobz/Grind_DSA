package javaVersion;

public class WordSearch {

    // TC ->O(M * N * 3^L),  SC -> O(L) where M*N is the size of the board
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length()) return true;

        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1
                || board[i][j] != word.charAt(idx)) {
            return false;
        }

        board[i][j] = '*';
        boolean result = exist(board, i - 1, j, word, idx + 1) ||
                exist(board, i, j - 1, word, idx + 1) ||
                exist(board, i, j + 1, word, idx + 1) ||
                exist(board, i + 1, j, word, idx + 1);

        board[i][j] = word.charAt(idx); // backtrack
        return result;
    }

}
