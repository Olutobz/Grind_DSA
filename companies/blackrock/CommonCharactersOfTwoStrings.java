package blackrock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Damola Olutoba Onikoyi
 * DATE: 13, September 2024
 * EMAIL: damexxey94@gmail.com
 */

/**
 * Write a program that accepts two sets of alphanumeric characters and performs an efficient match between them.
 * Finally, display the results.
 * <p>
 * NB: Avoid a single pre-built framework function that performs the work in a single line of code.
 * <blockquote>
 * <pre>
 * Input: two lines of input, each with a space-delimited series of values that represents the two sets,
 * 1 2 3 A B C
 * X 11 G M 2 9 3 C N R
 * output: 2 3 C
 * if no common values exist, return null
 * </pre>
 * </blockquote>
 */

public class CommonCharactersOfTwoStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        // hardcoded args for test
        System.out.println(findCommonCharactersOfTwoStrings("1 2 3 A B C", "X 11 G M 2 9 3 C N R"));
    }

    // TC -> O(n), SC -> O(n)
    private static String findCommonCharactersOfTwoStrings(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) {
            return "null";
        }

        String[] str1Arr = str1.split(" ");
        String[] str2Arr = str2.split(" ");

        Set<String> set1 = new HashSet<>(Arrays.asList(str1Arr));
        Set<String> set2 = new HashSet<>(Arrays.asList(str2Arr));
        Set<String> commonElems = new HashSet<>();

        for (String elem : set1) {
            if (set2.contains(elem)) {
                commonElems.add(elem);
            }
        }

        String[] output = new String[commonElems.size()];
        int index = 0;

        if (!commonElems.isEmpty()) {
            for (String elem : commonElems) {
                output[index++] = elem;
            }
            return Arrays.toString(output);
        }

        return "null";
    }
}
