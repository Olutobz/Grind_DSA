import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    // TC -> O(9^2), SC -> O(N) {if we use N = 9}
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        //check for rows
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
            }
        }

        // TC -> O(9^2), SC -> O(N)
        //check for cols
        for (int i = 0; i < 9; i++) {
            Set<Character> colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (colSet.contains(board[j][i])) {
                    return false;
                }
                colSet.add(board[j][i]);
            }
        }

        //block
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkBlock(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    // TC -> O(N^2), SC -> O(N)
    public boolean checkBlock(char[][] board, int idxI, int idxJ) {
        Set<Character> blockSet = new HashSet<>();
        int rows = idxI + 3;
        int cols = idxJ + 3;
        for (int i = idxI; i < rows; i++) {
            for (int j = idxJ; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (blockSet.contains(board[i][j])) {
                    return false;
                }
                blockSet.add(board[i][j]);
            }
        }

        return true;
    }

    // TC -> O(9^2), SC -> O(N) {if we use N = 9}
    public boolean isValidSudokuII(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !cols.add(board[j][i]))
                    return false;
                int cubeRow = 3 * (i / 3) + j / 3;
                int cubeCol = 3 * (i % 3) + j % 3;
                if (board[cubeRow][cubeCol] != '.' && !cube.add(board[cubeRow][cubeCol]))
                    return false;
            }
        }
        return true;

    }

}
