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

}
