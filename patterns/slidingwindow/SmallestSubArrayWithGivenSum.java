package slidingwindow;

public class SmallestSubArrayWithGivenSum {

    public static int smallestSubArray(int[] nums, int targetSum) {
        int windowStart = 0, currentWindowSum = 0;
        int minWindowSize = Integer.MIN_VALUE;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currentWindowSum += nums[windowEnd];
            while (currentWindowSum >= targetSum) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum -= nums[windowStart++];
            }
        }
        return minWindowSize;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4, 2, 2, 7, 8, 1, 2, 8, 10};
        int targetSum = 8;
        System.out.println(smallestSubArray(input, targetSum));
    }

}
