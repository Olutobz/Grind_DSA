package javaVersion;

public class UniquePathsIII {

    // TC ->O(4 * 3^(M*N) - 1) ~O(3^(M*N)), SC -> O(max(M, N))
    public int uniquePathsIII(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        int zero = 0;
        int sx = 0; // starting x index
        int sy = 0; // starting y index

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    zero++;
                } else if (grid[i][j] == 1) {
                    sx = i; // start x co-ordinate
                    sy = j; // start y co-ordinate
                }
            }
        }

        return path(grid, sx, sy, zero);
    }

    public int path(int[][] grid, int x, int y, int zero) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }

        if (grid[x][y] == 2) {
            // Why zero = -1, because in above example we have 9 zeros
            // So, when we reach the final cell we are covering one cell extra
            // then the zero counts again
            // If that's the case we find the path and return '1' otherwise return '0'
            return zero == -1 ? 1 : 0;
        }

        // mark the visited cells as -1 and reduce zero by 1
        grid[x][y] = -1;
        zero--;

        // calculate all the paths available in 4 directions
        int totalPaths = path(grid, x + 1, y, zero)
                + path(grid, x - 1, y, zero)
                + path(grid, x, y + 1, zero)
                + path(grid, x, y - 1, zero);

        // backtrack if we cannot reach all the paths
        grid[x][y] = 0;
        zero++;

        return totalPaths;

    }
}
