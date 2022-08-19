import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) list.add(1);
                else {
                    list.add(pascal.get(pascal.size() - 1).get(j)
                            + pascal.get(pascal.size() - 1).get(j - 1));
                }
            }
            pascal.add(list);
        }

        return pascal;
    }
}
