package interviews;

import java.util.HashSet;
import java.util.Set;

public class Demo {

    public static void main(String[] args) {
        System.out.println(hasSumWithPairs(new int[]{1, 2, 3, 9}, 14));
        System.out.println(hasSumWithPairs(new int[]{1, 2, 4, 4}, 8));
        System.out.println("-----");
        System.out.println(hasSumWithPairs(new int[]{1, 2, 3, 9}, 8));
        System.out.println(hasPairsWithSums(new int[]{1, 2, 4, 4}, 8));

    }

    /* (Q1) You have a collection of integers, find a matching pair that is equal to a given sum.
     * [1, 2, 3, 9] where sum = 8
     * [1  2, 4, 4,] where sum = 8
     *
     * [Approach 1] O(N) -> The idea is to have two pointers on the low(i.e first) & high(i.e last) elems.
     * This gives a pair which we can compare to the sum we are looking for. Iterate through the array,
     * and we move low or high indices depending on if the current pair is lower or higher than the target sum.
     *
     * [Approach 2] O(N) -> The idea is to use an HashSet<Integer> to store and look up the complement of
     * each element in the array data. Iterate through the array and check if it's complement is present
     * in the HashSet, if present indicate that pair has been found; otherwise add the necessary complement.
     *
     * */

    // Time Complexity -> O(N)
    // Space Complexity -> o(1)
    public static boolean hasSumWithPairs(final int[] data, int sum) {
        int low = 0;
        int high = data.length - 1;
        while (low < high) {
            int pair = data[low] + data[high];
            if (pair == sum) return true;
            else if (pair < sum) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }

    // Time Complexity -> O(N)
    // Space Complexity -> O(N)
    public static boolean hasPairsWithSums(final int[] data, int sum) {
        Set<Integer> complement = new HashSet<>();
        for (int value : data) {
            if (complement.contains(value)) {
                return true;
            }
            complement.add(sum - value); // this could underflow
        }
        return false;
    }

}
