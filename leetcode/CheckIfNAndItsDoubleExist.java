import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {

    // TC -> O(N^2), SC -> O(1)
    public boolean checkIfExist(int[] arr) {
        if (arr == null) return false;
        for (int n = 0; n < arr.length; n++) {
            for (int m = 0; m < arr.length; m++) {
                if (arr[n] == arr[m] * 2 && n != m) return true;
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
