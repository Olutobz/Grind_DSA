public class ConcatenationOfArray {
    // TC -> O(N), SC -> O(N)
    public int[] getConcatenation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }
}
