package java;

public class SearchA2DMatrix {


    // TC -> O(M*N), SC -> O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    // TC -> O(M + N), SC -> O(1)
    public boolean searchMatrixII(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0, end = cols - 1;

        while (start < rows && end >= 0) {
            if (matrix[start][end] == target) return true;
            else if (matrix[start][end] > target) end--;
            else start++;
        }
        return false;
    }

    // TC -> O(LogM + LogN) -> O(Log(M*N)), SC -> O(1)
    public boolean searchMatrixIII(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0, end = rows * cols - 1;

        while (start <= end) {
            int pivotIndex = start + (end - start) / 2;
            // formulae => a[x] : matrix[x / m][x % m] where m -> column of the matrix
            int pivotElem = matrix[pivotIndex / cols][pivotIndex % cols];
            if (target == pivotElem) return true;
            else if (target < pivotElem) end = pivotIndex - 1;
            else start = pivotIndex + 1;
        }
        return false;
    }

}
