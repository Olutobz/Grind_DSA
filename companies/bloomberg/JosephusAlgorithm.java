package bloomberg;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 05, November 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * Given a number k start counting from one of the kids. the kid who counted the num k goes out of circle,
 * continue from the next kid until there only one kid left. find the last kid.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * int n = 6;
 * int k = 3;
 * output = 1
 * </pre>
 * </blockquote>
 */

public class JosephusAlgorithm {

    // TC -> O(n), SC -> O(1)
    public static int josephus(int n, int k) {
        int survivor = 0;
        for (int i = 2; i <= n; i++) {
            survivor = (survivor + k) % i;
        }

        return survivor + 1;
    }
}
