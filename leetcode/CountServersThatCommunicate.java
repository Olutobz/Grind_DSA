public class CountServersThatCommunicate {
    // TC -> O(N * M), SC -> O(N + M)
    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int numRows = grid.length;
        int numCols = grid[0].length;
        int[] countServersInRow = new int[numRows];
        int[] countServersInCol = new int[numCols];
        int totalServers = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 1) {
                    countServersInRow[i]++;
                    countServersInCol[j]++;
                    totalServers++;
                }
            }
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 1) {
                    if (countServersInRow[i] == 1 && countServersInCol[j] == 1) {
                        totalServers--;
                    }
                }
            }
        }

        return totalServers;
    }

    // TC -> O(N * M), SC -> O(N + M)
    public int countServersII(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] rowCnt = new int[rows], colCnt = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }

        int totalServers = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && (rowCnt[i] > 1 || colCnt[j] > 1)) {
                    totalServers++;
                }
            }
        }

        return totalServers;
    }


    // TC -> O(N * M), SC -> O(N + M)
    public int countServersIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // rc, cc for row count, column count;
        int[] rc = new int[m];
        int[] cc = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                rc[i]++;
                cc[j]++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                if (rc[i] > 1 || cc[j] > 1) res++;
            }
        }
        return res;
    }

}
