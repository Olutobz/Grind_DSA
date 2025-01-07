package javaVersion;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target.
 * Write a function to search target in nums. If a target exists, then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <blockquote> <pre>
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * </pre></blockquote>
 */

public class BinarySearch {

    // TC -> O(LogN), SC -> O(1)
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    // TC -> O(LogN), SC -> O(1)
    private int searchII(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[start] == target ? start : -1;
    }

    // TC -> O(LogN), SC -> O(LogN)
    private int searchIII(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        return recursiveSearch(nums, target, start, end);
    }

    private int recursiveSearch(int[] nums, int target, int start, int end) {
        if (nums == null || nums.length == 0 || start > end) return -1;

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return recursiveSearch(nums, target, ++mid, end);
        } else {
            return recursiveSearch(nums, target, start, --mid);
        }
    }
}
