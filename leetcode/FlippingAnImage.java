/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 12, August 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.
 * <p>
 * For example, flipping [1,1,0] horizontally results in [0,1,1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * <p>
 * For example, inverting [0,1,1] results in [1,0,0].
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: image = [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * Example 2:
 * Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *     </pre>
 * </blockquote>
 */

public class FlippingAnImage {

    // TC -> O(N^2), SC -> O(1)
    public int[][] flipAndInvertImage(int[][] image) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }

        for (int[] row : image) {
            int start = 0;
            int end = row.length - 1;
            while (start <= end) {
                if (row[start] == row[end]) {
                    row[start] = 1 - row[start];
                    row[end] = row[start];
                }
                start++;
                end--;
            }
        }

        return image;
    }
}
