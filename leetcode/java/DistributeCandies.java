package java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    // TC -> O(N^2), SC -> O(1)
    public int distributeCandies(int[] candyType) {
        int uniqueCandies = 0;
        int totalCandies = candyType.length / 2;
        for (int i = 0; i < candyType.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (candyType[i] == candyType[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) uniqueCandies++;
        }

        return Math.min(uniqueCandies, totalCandies);

    }

    // TC -> O(NLogN), SC -> O(1)
    public int distributeCandiesI(int[] candyType) {
        Arrays.sort(candyType);
        int uniqueCandies = 1;
        int totalCandies = candyType.length / 2;

        for (int i = 1; i < candyType.length && uniqueCandies < totalCandies; i++) {
            if (candyType[i] != candyType[i - 1]) {
                uniqueCandies++;
            }
        }

        return Math.min(uniqueCandies, totalCandies);
    }

    // TC -> O(N), SC -> O(N)
    public int distributeCandiesII(int[] candyType) {
        Set<Integer> candiesSet = new HashSet<>();
        int totalCandies = candyType.length;

        for (int candy : candyType) {
            candiesSet.add(candy);
        }
        return Math.min(candiesSet.size(), totalCandies / 2);

    }

}
