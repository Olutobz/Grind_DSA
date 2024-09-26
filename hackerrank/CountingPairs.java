/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 12, August 2024
 * EMAIL: damexxey94@gmail.com
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer k and a list of integers, count the number of distinct valid pairs of integers (a,b)
 * in the list for which a + k = b. Two pairs of integers (a,b) and (c,d) are considered distinct
 * if at least one element of (a,b) does not also belong to (c,d).
 * <p>
 * Note that the elements in a pair might be the same element in the array.
 * An instance of this is below where k = 0
 * <p>
 * <blockquote>
 * <pre>
 * Example 1:
 * n = 4
 * Numbers = [1, 1, 1, 2]
 * K = 1
 * Valid pairs are (1,1) and (1,2) and (2,2) for k = 1
 * a + k = b for t pair (a,b) = (1,2)
 * </pre>
 * </blockquote>
 */

public class CountingPairs {

    // TC -> O(N), SC -> O(N)
    private static int countValidPairs(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        Set<String> pairs = new HashSet<>();
        int count = 0;

        for (int num : nums) {
            if (seen.contains(num + k)) {
                String pair = num + "," + (num + k);
                if (!pairs.contains(pair)) {
                    pairs.add(pair);
                    count++;
                }
            }

            if (seen.contains(num - k)) {
                String pair = (num - k) + "," + num;
                if (!pairs.contains(pair)) {
                    pairs.add(pair);
                    count++;
                }
            }

            seen.add(num);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countValidPairs(new int[]{1, 1, 1, 2}, 1));
        System.out.println(countValidPairs(new int[]{1, 1, 2, 9, 5}, 2));
        // a + k = b; k = 2
    }

}
