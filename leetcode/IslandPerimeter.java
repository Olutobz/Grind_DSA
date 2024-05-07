public class IslandPerimeter {

    // TC -> O(M * N), SC -> O(M + N)
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        count++; // UP
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        count++; // LEFT
                    }
                    if (i == rows - 1 || grid[i + 1][j] == 0) {
                        count++; // DOWN
                    }
                    if (j == cols - 1 || grid[i][j + 1] == 0) {
                        count++; // RIGHT
                    }
                }
            }
        }
        return count;
    }


    // TC -> O(M * N), SC -> O(M + N)
    public int islandPerimeterII(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        int count = 0;

        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d : dir) {
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || y < 0 || x == m || y == n || grid[x][y] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    // Recursive
    // TC -> O(M*N + 4^(M*N)), SC -> O(M + N)
    public int islandPerimeterIII(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return helper(grid, dir, i, j);
                }
            }
        }
        return 0;
    }

    int helper(int[][] grid, int[][] dir, int i, int j) {

        int m = grid.length, n = grid[0].length;
        grid[i][j] = -1;

        int count = 0;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) {
                count++;
            } else {
                if (grid[x][y] == 1) {
                    count += helper(grid, dir, x, y);
                }
            }
        }
        return count;
    }
}
