import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    // TC -> O(N^2), SC -> O(1)
    public int distributeCandies(int[] candyType) {
        int uniqueCandies = 0;
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

        return Math.min(uniqueCandies, candyType.length / 2);

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
