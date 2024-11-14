package robinhood;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Find the common elements in 2 lists
 */
public class CommonElements {

    // TC -> O(n), SC -> O(n)
    public static List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer elem : list1) {
            set1.add(elem);
        }

        for (Integer element : list2) {
            if (set1.contains(element)) {
                result.add(element);
                set1.remove(element);
            }
        }
        return result;
    }
}