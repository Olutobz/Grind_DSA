public class MedianOfTwoSortedArrays {

    // TC -> O(N + M), SC -> O(N + M)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
}
