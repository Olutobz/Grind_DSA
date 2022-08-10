package warmup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WarmUpTest {

    public static int sockMerchant(List<Integer> ar) {
        int n = ar.size();
        if (n == 0) return -1;
        Set<Integer> set = new HashSet<>();
        int pairs = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(ar.get(i))) {
                pairs++;
                set.remove(ar.get(i));
            } else {
                set.add(ar.get(i));
            }
        }

        return pairs;
    }

}
