import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    // TC -> O(M * N), SC -> O(1) (if we ignore the arrayList returned)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int minRow = 0, maxRow = matrix.length - 1;
        int minCol = 0, maxCol = matrix[0].length - 1;

        while (minRow <= maxRow && minCol <= maxCol) {
            // Go Right
            for (int col = minCol; col <= maxCol; col++) {
                list.add(matrix[minRow][col]);
            }
            minRow++;

            // Go Down
            for (int row = minRow; row <= maxRow; row++) {
                list.add(matrix[row][maxCol]);
            }
            maxCol--;

            // Go Left
            for (int col = maxCol; minRow <= maxRow && col >= minCol; col--) {
                list.add(matrix[maxRow][col]);
            }
            maxRow--;

            // Go Up
            for (int row = maxRow; minCol <= maxCol && row >= minRow; row--) {
                list.add(matrix[row][minCol]);
            }
            minCol++;

        }

        return list;
    }

}
