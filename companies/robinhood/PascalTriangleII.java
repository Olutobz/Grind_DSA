package robinhood;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

    // TC -> O(N^2), SC -> O(N)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            list.add(1);
        }
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }

        return list;
    }

    // TC -> O(N^2), SC -> O(N^2)
    public List<Integer> getRowII(int rowIndex) {
        List<List<Integer>> pascal = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) list.add(1);
                else {
                    list.add(pascal.get(i - 1).get(j)
                            + pascal.get(i - 1).get(j - 1));
                }
            }
            pascal.add(list);
        }

        return pascal.get(rowIndex);
    }

}
