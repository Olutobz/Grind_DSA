package javaVersion;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {

    // TC -> O(N^2), SC -> O(1)
    public boolean checkIfExist(int[] arr) {
        if (arr == null) return false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] * 2 && i != j) return true;
            }
        }
        return false;
    }

    // TC -> O(N), SC -> O(N)
    public boolean checkIfExistFaster(int[] arr) {
        Set<Integer> comp = new HashSet<>();
        for (int num : arr) {
            if (comp.contains(num * 2) || (num % 2 == 0 && comp.contains(num / 2))) {
                return true;
            }
            comp.add(num);
        }
        return false;
    }
}
