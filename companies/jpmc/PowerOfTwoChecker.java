package jpmc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 10, September 2024
 * EMAIL: damexxey94@gmail.com
 */

public class PowerOfTwoChecker {

    // TC -> O(n), SC -> O(1) [if we don't consider the output list]
    private List<Integer> getListFromPowerOfTwo(List<Integer> arr) {
        if (arr.isEmpty()) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        for (int num : arr) {
            if (isPowerOfTwo(num)) {
                res.add(1);
            } else {
                res.add(0);
            }
        }
        return res;
    }

    // TC -> O(1), SC -> O(1)
    private boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    // TC -> O(log n), SC -> O(1)
    private boolean isPowerOfTwoII(int num) {
        if (num == 0) return false;
        while (num % 2 == 0) {
            num /= 2;
        }
        return num == 1;
    }
}
