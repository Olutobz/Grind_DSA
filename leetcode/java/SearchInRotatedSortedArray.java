package java;

public class SearchInRotatedSortedArray {

    // TC -> O(N), SC -> O(1)
    public int search(int[] nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans = i;
                break;
            } else {
                ans = -1;
            }

        }
        return ans;
    }

    // TC -> O(LogN), SC -> O(1)
    public int searchII(int[] nums, int target) {
        int minIdx = findMinIdx(nums);
        if (target == nums[minIdx]) return minIdx;
        int m = nums.length;
        int start = (target <= nums[m - 1]) ? minIdx : 0;
        int end = (target > nums[m - 1]) ? minIdx : m - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    private int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    // TC -> O(LogN), SC -> O(1)
    public int searchIII(int[] nums, int target) {
        int minIndex = minIndex(nums);
        int leftSearch = binarySearch(nums, 0, minIndex - 1, target);
        int rightSearch = binarySearch(nums, minIndex, nums.length - 1, target);
        if (leftSearch != -1) {
            return leftSearch;
        } else return rightSearch;
    }

    // TC -> O(LogN), SC -> O(1)
    public int minIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = (mid - 1 + nums.length) % nums.length;
            int next = (mid + 1) % nums.length;
            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                return mid;
            } else if (nums[mid] <= nums[end]) {
                end = mid - 1;
            } else if (nums[mid] >= nums[start]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
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

}
