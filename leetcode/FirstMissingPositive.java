import java.util.Arrays;

public class FirstMissingPositive {

    // TC -> O(NlogN), SC -> O(sorting)
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        for (int num : nums) {
            if (num < 1) continue;
            else {
                if (num == res) {
                    res++;
                } else if (num > res) {
                    return res;
                }
            }
        }
        return res;
    }
}
