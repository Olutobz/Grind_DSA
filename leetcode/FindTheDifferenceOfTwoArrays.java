import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {

    // TC -> O(N), SC -> O(N)
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return result;
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int num : set1) {
            if (set2.contains(num)) {
                set2.remove(num);
            } else {
                list1.add(num);
            }
        }

        for (int num : set2) {
            list2.add(num);
        }

        result.add(list1);
        result.add(list2);

        return result;
    }
}
