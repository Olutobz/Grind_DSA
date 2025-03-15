package javaVersion;

import java.util.ArrayList;
import java.util.List;


/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

public class ProductOfTheLastKNumbers {
    List<Integer> list;

    // TC -> O(1), SC -> O(N)
    public void ProductOfNumbers() {
        list = new ArrayList<>();
    }

    // TC -> O(1), SC -> O(1)
    public void add(int num) {
        if (num == 0) {
            list.clear();
        } else if (list.isEmpty()) {
            list.add(num);
        } else {
            // Store the product upfront
            int n = list.get(list.size() - 1);
            list.add(n * num);
        }
    }

    // TC -> O(1), SC -> O(1)
    public int getProduct(int k) {
        int len = list.size();
        if (len < k) return 0;
        if (len == k) return list.get(len - 1);
        return list.get(len - 1) / list.get(len - k - 1);
    }

    // TC -> O(1), SC -> O(N)
    static class ProductOfNumbersII {

        List<Integer> list;

        public ProductOfNumbersII() {
            list = new ArrayList<>();
            list.add(1);
        }

        public void add(int num) {
            if (num > 0)
                list.add(list.get(list.size() - 1) * num);
            else {
                list = new ArrayList<>();
                list.add(1);
            }
        }

        public int getProduct(int k) {
            int n = list.size();
            return k < n ? list.get(n - 1) / list.get(n - k - 1) : 0;
        }
    }

    // TC -> O(N), SC -> O(N)
    static class ProductOfNumbersIII {
        ArrayList<Integer> list;

        // TC -> O(1), SC -> O(N)
        public ProductOfNumbersIII() {
            list = new ArrayList<>();
        }

        // TC -> O(1), SC -> O(1)
        public void add(int num) {
            list.add(num);
        }

        // TC -> O(N), SC -> O(1)
        public int getProduct(int k) {
            int product = 1;
            for (int i = list.size() - k; i < list.size(); i++) {
                product *= list.get(i);
            }
            return product;
        }
    }

}

