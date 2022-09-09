public class TransposeMatrix {

    // TC -> O(R * C), SC -> O(R * C)
    public int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[][]{};
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] transposeMatrix = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        return transposeMatrix;
    }

    // TC -> O(R * C) -> O(m ^ 2), SC -> O(1)
    public int[][] transposeSquareMatrix(int[][] matrix) {
        // if the size of row == size of col (A Square Matrix)
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        return matrix;
    }
}
