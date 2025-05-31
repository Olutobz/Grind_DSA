package javaVersion;

import java.util.*;

/**
 * Given two sparse matrices A of size m x k and B of size k x n, return the result of AB.
 * You may assume that A's column number is equal to B's row number; also that multiplication is always possible.
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: A = [[1,0,0],[-1,0,3]], B = [[7,0,0],[0,0,0],[0,0,1]]
 * Output: [[7,0,0],[-7,0,3]]
 *
 * Example 2:
 * Input: A = [[0]], B = [[0]]
 * Output: [[0]]
 * </pre>
 * </blockquote>
 */
public class SparseMatrixMultiplication {

    // TC -> O(m * n * k), SC -> O(m * n), where m = A and n = B
    public static int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new int[0][0];
        }

        int aRow = A.length;
        int aCol = A[0].length;
        int bCol = B[0].length;

        Map<Integer, Map<Integer, Integer>> nonZeroMap = new HashMap<>();
        for (int i = 0; i < aRow; i++) {
            nonZeroMap.put(i, new HashMap<>());
            for (int j = 0; j < aCol; j++) {
                if (A[i][j] != 0) {
                    nonZeroMap.get(i).put(j, A[i][j]);
                }
            }
        }

        int[][] result = new int[aRow][bCol];
        for (int i = 0; i < aRow; i++) {
            for (int k : nonZeroMap.get(i).keySet()) {
                for (int j = 0; j < bCol; j++) {
                    if (B[k][j] != 0) {
                        result[i][j] += nonZeroMap.get(i).get(k) * B[k][j];
                    }
                }
            }
        }

        return result;
    }

    // TC -> O(m * n), SC -> O(max(n, m)), where m = A and n = B
    public static int[][] multiplyII(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        int aRow = A.length;
        int aCol = A[0].length;
        int bCol = B[0].length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < aRow; ++i) {
            for (int j = 0; j < aCol; ++j) {
                if (A[i][j] != 0) {
                    map.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        int[][] result = new int[aRow][bCol];
        for (int i = 0; i < aRow; ++i) {
            for (int j = 0; j < bCol; ++j) {
                if (map.containsKey(i)) {
                    for (int k : map.get(i)) {
                        result[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(multiply(
                new int[][]{{1, 0, 0}, {-1, 0, 3}},
                new int[][]{{7, 0, 0}, {0, 0, 0}, {0, 0, 1}}
        )));

        System.out.println(Arrays.deepToString(multiplyII(
                new int[][]{{1, 0, 0}, {-1, 0, 3}},
                new int[][]{{7, 0, 0}, {0, 0, 0}, {0, 0, 1}}
        )));
    }

}
