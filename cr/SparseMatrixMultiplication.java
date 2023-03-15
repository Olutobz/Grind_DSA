import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class SparseMatrixMultiplication {

    /**
     * Given two sparse matrices mat1 of size m x k and mat2 of size k x n, return the result of mat1 x mat2.
     * You may assume that multiplication is always possible.
     * <p>
     * Example 1:
     * Input: mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]]
     * Output: [[7,0,0],[-7,0,3]]
     * <p>
     * Example 2:
     * Input: mat1 = [[0]], mat2 = [[0]]
     * Output: [[0]]
     */

    // TC -> O(N * M), SC -> O(max(N, M)), where M = mat1 and N = mat2
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int r1 = mat1.length;
        int c1 = mat1[0].length;
        int c2 = mat2[0].length;

        int[][] res = new int[r1][c2];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < r1; ++i) {
            for (int j = 0; j < c1; ++j) {
                if (mat1[i][j] != 0) {
                    map.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        for (int i = 0; i < r1; ++i) {
            for (int j = 0; j < c2; ++j) {
                if (map.containsKey(i)) {
                    for (int k : map.get(i)) {
                        res[i][j] += mat1[i][k] * mat2[k][j];
                    }
                }
            }
        }

        return res;
    }

}
