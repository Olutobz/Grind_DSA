public class RemoveElement {

    // TC -> O(N), SC -> O(1)
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    // TC -> O(N), SC -> O(1)
    public int removeElementII(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int end = nums.length;
        int i = 0;
        while (i < end) {
            if (nums[i] == val) {
                nums[i] = nums[end - 1];
                end--;
            } else {
                i++;
            }
        }
        return end;
    }
}
