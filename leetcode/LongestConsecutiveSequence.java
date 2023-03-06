import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
            while (set.remove(left)) left--;
            while (set.remove(right)) right++;
            ans = Math.max(ans, right - left - 1);
            if (set.isEmpty()) return ans;//save time if there are items in nums, but no item in hashset.
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
