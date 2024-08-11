import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 10, August 2024
 * EMAIL: damexxey94@gmail.com
 */


/**
 * You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
 * <p>
 * The 2D array should contain only the elements of the array nums.
 * Each row in the 2D array contains distinct integers.
 * The number of rows in the 2D array should be minimal.
 * Return the resulting array. If there are multiple answers, return any of them.
 * <p>
 * Note that the 2D array can have a different number of elements on each row.
 *
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [1,3,4,1,2,3,1]
 * Output: [[1,3,4,2],[1,3],[1]]
 * Explanation: We can create a 2D array that contains the following rows:
 * - 1,3,4,2
 * - 1,3
 * - 1
 * All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
 * It can be shown that we cannot have less than 3 rows in a valid array.
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: [[4,3,2,1]]
 * Explanation: All elements of the array are distinct, so we can keep all of them in the first row of the 2D array.
 * </pre>
 * </blockquote>
 */


public class ConvertAnArrayIntoA2DArrayWithConditions {

    // TC -> O(N), SC -> O(N)
    private List<List<Integer>> findMatrixII(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int[] freqCounter = new int[nums.length + 1];
        for (int num : nums) {
            freqCounter[num]++;
        }

        for (int i = 1; i <= nums.length; i++) {
            int freq = freqCounter[i];
            for (int j = 0; j < freq; j++) {
                if (result.size() <= j) {
                    result.add(new ArrayList<>());
                }
                result.get(j).add(i);
            }
        }

        return result;
    }

    // TC -> O(N), SC -> O(N)
    private List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (result.size() < map.get(num)) {
                result.add(new ArrayList<>());
            }
            result.get(map.get(num) - 1).add(num);
        }

        return result;
    }

}
