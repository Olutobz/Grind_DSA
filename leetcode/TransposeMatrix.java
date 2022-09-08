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

    // TC -> O(R * C), SC -> O(R * C)
    public int[][] transposeII(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] transposeMatrix = new int[col][row];

        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        return transposeMatrix;
    }

}
