import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * <blockquote>
 * <pre>
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Example 3:
 * Input: nums = [1,0,1,2]
 * Output: 3
 *
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * </pre>
 * </blockquote>
 */

public class LongestConsecutiveSequence {

    // TC -> O(N), SC -> O(N)
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        Set<Integer> set = new HashSet<>();
        int longestStreak = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currStreak = 1;

                while (set.contains(num + 1)) {
                    num++;
                    currStreak++;
                }
                longestStreak = Math.max(currStreak, longestStreak);
            }
        }

        return longestStreak;
    }

    // TC -> O(N), SC -> O(N)
    public int longestConsecutiveII(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);

        int ans = 0;
        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while (set.remove(left)) {
                left--;
            }
            while (set.remove(right)) {
                right++;
            }
            ans = Math.max(ans, right - left - 1);
            //save time if there are items in nums, but no item in hashset.
            if (set.isEmpty()) return ans;
        }
        return ans;
    }

    // TC -> O(NLogN), SC -> O(1)
    public int longestConsecutiveIII(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int curr = nums[0];
        int count = 1;
        int longestStreak = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] == curr + 1) {
                curr++;
                count++;
                longestStreak = Math.max(longestStreak, count);
            } else {
                curr = nums[i];
                count = 1;
            }
        }
        return longestStreak;
    }

}
