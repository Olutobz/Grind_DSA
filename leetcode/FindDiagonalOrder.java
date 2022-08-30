import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDiagonalOrder {

    // TC -> O(M * N), M = number of rows, N = number of columns.
    // SC -> O(1), (if we ignore the returned array)
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        int m = mat.length, n = mat[0].length;
        int row = 0, col = 0;
        int[] result = new int[m * n];

        for (int i = 0; i < result.length; i++) {
            result[i] = mat[row][col];
            // even sum diagonal -> go up
            if ((row + col) % 2 == 0) {
                if (col == n - 1) row++;
                else if (row == 0) col++;
                else {
                    row--;
                    col++;
                }
            }
            // odd sum diagonal -> go down
            else if ((row + col) % 2 == 1) {
                if (row == m - 1) col++;
                else if (col == 0) row++;
                else {
                    row++;
                    col--;
                }
            }

        }

        return result;
    }

    // TC -> O(M * N), SC -> O(N) (The Set will take extra memory to store int values)
    public int[] findDiagonalOrderII(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int indexSum = i + j;
                if (!diagonalMap.containsKey(indexSum)) {
                    diagonalMap.put(indexSum, new ArrayList<>());
                }

                if (indexSum % 2 == 0) diagonalMap.get(indexSum).add(0, mat[i][j]);
                else diagonalMap.get(indexSum).add(mat[i][j]);
            }
        }

        int index = 0;
        int[] result = new int[mat.length * mat[0].length];
        for (int indexSum : diagonalMap.keySet()) {
            for (int val : diagonalMap.get(indexSum)) {
                result[index++] = val;
            }
        }

        return result;
    }

}
