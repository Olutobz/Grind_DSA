import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SockMerchant {

    // TC -> O(N), SC -> O(N)
    public static int sockMerchant(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) return -1;

        Set<Integer> set = new HashSet<>();
        int pairs = 0;
        for (Integer elem : arr) {
            if (set.contains(elem)) {
                pairs++;
                set.remove(elem);
            } else {
                set.add(elem);
            }
        }
        return pairs;
    }

}

