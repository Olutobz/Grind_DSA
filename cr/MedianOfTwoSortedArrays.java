public class MedianOfTwoSortedArrays {

    // TC -> O(N + M), SC -> O(N + M)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0.0;
        double median;
        int i = 0, j = 0, k = 0;
        int m = nums1.length, n = nums2.length;
        int[] result = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }

        while (i < m) {
            result[k++] = nums1[i++];
        }

        while (j < n) {
            result[k++] = nums2[j++];
        }

        if (result.length % 2 == 0) {
            median = result[result.length / 2] + result[(result.length / 2) - 1];
            median = median / 2;
        } else {
            median = result[result.length / 2];
        }

        return median;
    }

    public double findMedianSortedArraysII(int[] nums1, int[] nums2) {
        // Deal with invalid corner case.
        if (nums1 == null || nums2 == null) return 0.0;

        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2; //left half of the combined median
        int r = (m + n + 2) / 2; //right half of the combined median

        // If the nums1.length + nums2.length is odd, the 2 function will return the same number
        // Else if nums1.length + nums2.length is even, the 2 function will
        // return the left number and right number that make up a median
        return (getKth(nums1, 0, nums2, 0, l)
                + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    private double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // This function finds the Kth element in nums1 + nums2

        // If nums1 is exhausted, return kth number in nums2
        if (start1 > nums1.length - 1) return nums2[start2 + k - 1];

        // If nums2 is exhausted, return kth number in nums1
        if (start2 > nums2.length - 1) return nums1[start1 + k - 1];

        // If k == 1, return the first number
        // Since nums1 and nums2 is sorted, the smaller one among the start point of nums1 and nums2 is the first one
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;

        if (start1 + k / 2 - 1 < nums1.length) {
            mid1 = nums1[start1 + k / 2 - 1];
        }

        if (start2 + k / 2 - 1 < nums2.length) {
            mid2 = nums2[start2 + k / 2 - 1];
        }

        // Throw away half of the array from nums1 or nums2. And cut k in half
        if (mid1 < mid2) {
            // nums1.right + nums2
            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            // nums1 + nums2.right
            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }

}
