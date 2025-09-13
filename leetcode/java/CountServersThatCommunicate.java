package java;

public class CountServersThatCommunicate {

    // TC -> O(N * M), SC -> O(N + M); where N -> Rows and M -> Columns
    public int countServers(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] rowCount = new int[rows], colCount = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int totalServers = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    totalServers++;
                }
            }
        }
        return totalServers;
    }

    // TC -> O(N * M), SC -> O(N + M); where N -> Rows and M -> Columns
    public int countServersII(int[][] grid) {
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

    // TC -> O(N * M), SC -> O(N + M); where N -> Rows and M -> Columns
    public int countServersIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        int totalServers = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                rowCount[i]++;
                colCount[j]++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                if (rowCount[i] > 1 || colCount[j] > 1) totalServers++;
            }
        }
        return totalServers;
    }

}
