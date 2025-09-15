package java;

import java.util.HashSet;
import java.util.Set;


/**
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 *
 * Example 2:
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
 * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 *
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 * </pre>
 * </blockquote>
 */

public class ValidSudoku {

    // TC -> O(n^2) ~O(9^2), SC -> O(n) = ~O(1) {if we use n = 9}
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        for (int row = 0; row < 9; row++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[row][j] == '.') {
                    continue;
                }
                if (rowSet.contains(board[row][j])) {
                    return false;
                }
                rowSet.add(board[row][j]);
            }
        }

        for (int col = 0; col < 9; col++) {
            Set<Character> colSet = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == '.') {
                    continue;
                }
                if (colSet.contains(board[i][col])) {
                    return false;
                }
                colSet.add(board[i][col]);
            }
        }

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
    public boolean checkBlock(char[][] board, int rowIndex, int colIndex) {
        Set<Character> blockSet = new HashSet<>();
        int rows = rowIndex + 3;
        int cols = colIndex + 3;
        for (int i = rowIndex; i < rows; i++) {
            for (int j = colIndex; j < cols; j++) {
                if (board[i][j] != '.' && blockSet.contains(board[i][j])) {
                    return false;
                }
                blockSet.add(board[i][j]);
            }
        }

        return true;
    }

    // TC -> O(n^2) ~O(9^2), SC -> O(n) = ~O(1) {if we use n = 9}
    public boolean isValidSudokuII(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        for (int row = 0; row < 9; row++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> squares = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.' && !rows.add(board[row][col])) {
                    return false;
                }
                if (board[col][row] != '.' && !cols.add(board[col][row])) {
                    return false;
                }

                int cubeRow = 3 * (row / 3) + col / 3;
                int cubeCol = 3 * (row % 3) + col % 3;

                if (board[cubeRow][cubeCol] != '.' && !squares.add(board[cubeRow][cubeCol])) {
                    return false;
                }
            }
        }

        return true;
    }

}
