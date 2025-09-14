package java;

public class MergeSortedArray {

    // TC -> O(M + N), SC -> O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1; i >= 0; i--) {
            if (m > 0 && n > 0) {
                if (nums2[n - 1] > nums1[m - 1]) {
                    nums1[i] = nums2[n - 1];
                    n--;
                } else {
                    nums1[i] = nums1[m - 1];
                    m--;
                }
            } else if (m > 0) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
    }

    // TC -> O(M + N), SC -> O(1)
    public void mergeII(int[] nums1, int m, int[] nums2, int n) {
        int arr1Index = m - 1, arr2Index = n - 1, index = m + n - 1;
        while (arr2Index >= 0) {
            if (arr1Index >= 0 && nums1[arr1Index] > nums2[arr2Index]) {
                nums1[index] = nums1[arr1Index];
                arr1Index--;
                index--;
            } else {
                nums1[index] = nums2[arr2Index];
                index--;
                arr2Index--;
            }
        }
    }
}
