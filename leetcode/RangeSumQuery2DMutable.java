public class RangeSumQuery2DMutable {

    static class NumMatrix {
        int[][] sum;

        // Tc -> O(m*n), SC -> O(m*n)
        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            sum = new int[m + 1][n + 1];
            // sum[i][j] is sum of all elements inside the rectangle [0,0,i,j]
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        // Tc -> O(1), SC -> O(1)
        public int sumRegion(int row1, int col1, int row2, int col2) {
            row1++;
            col1++;
            row2++;
            col2++;

            // Since our `sum` starts by 1, so we need to increase r1, c1, r2, c2 by 1
            return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}
