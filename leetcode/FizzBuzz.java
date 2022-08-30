import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    // TC -> O(N), SC -> O(N)
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String currStr = "";
            if (i % 3 == 0) {
                currStr += "Fizz";
            }
            if (i % 5 == 0) {
                currStr += "Buzz";
            }
            if (currStr.isEmpty()) {
                currStr += String.valueOf(i);
            }
            result.add(currStr);
        }
        return result;
    }

}
