import java.util.Random;

public class RandomPickWithWeight {

    static class Solution {
        Random random;
        int[] weightSums;

        // TC -> O(N), SC -> O(N)
        public Solution(int[] w) {
            this.random = new Random();
            for (int i = 1; i < w.length; i++) {
                w[i] += w[i - 1];
            }
            this.weightSums = w;
        }

        // TC -> O(LogN), SC -> O(1)
        public int pickIndex() {
            int len = weightSums.length;
            // there is no 0 weight, we need to +1 to avoid getting 0 from the random function
            int idx = random.nextInt(weightSums[len - 1]) + 1;
            int start = 0, end = len - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (weightSums[mid] == idx) {
                    return mid;
                } else if (weightSums[mid] < idx) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return start;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
