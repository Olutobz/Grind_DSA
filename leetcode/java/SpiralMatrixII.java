package java; /**
 * Created by Damola Olutoba Onikoyi
 * DATE: 14, October 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 *
 * Example 2:
 * Input: n = 1
 * Output: [[1]]
 * </pre>
 * </blockquote>
 */

public class SpiralMatrixII {

    // TC -> O(n^2), SC -> O(1)
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, top = 0;
        int right = n - 1, bottom = n - 1;
        int count = 1;

        while (left <= right) {
            for (int j = left; j <= right; j++) {
                res[top][j] = count++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res[i][right] = count++;
            }
            right--;

            for (int j = right; j >= left; j--) {
                res[bottom][j] = count++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                res[i][left] = count++;
            }
            left++;
        }

        return res;
    }
}
