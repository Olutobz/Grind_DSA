public class SudokuSolver {

    //  TC ->O(9^m),  SC -> O(9^m) (m represents the number of blanks to be filled in),
    public void solveSudoku(char[][] board) {
        doSolve(board, 0);
    }

    private boolean doSolve(char[][] board, int row) {
        for (int i = row; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, i, j, num)) {
                        board[i][j] = num;
                        if (doSolve(board, i)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // Block number is i/3, the first element is i/3*3
        int blkRow = (row / 3) * 3, blkCol = (col / 3) * 3;
        for (int i = 0; i < 9; i++)
            if (board[i][col] == num || board[row][i] == num ||
                    board[blkRow + i / 3][blkCol + i % 3] == num)
                return false;
        return true;
    }

}
