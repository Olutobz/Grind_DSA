
import java.util.Arrays;

public class Test {

    public static void printArray(int[][] arr) {

        for (int[] num : arr) {
            System.out.println(Arrays.toString(num));
        }

        for (int[] nums : arr) {
            for (int j = 0; nums != null && j < nums.length; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }
        /*  for (int[] a : arr) {
            for (int val : a) {
                System.out.print(val + " ");
            }
            System.out.println();
            }
        * */

    }

    public static void main(String[] args) {
        int[][] a = new int[2][4];
        printArray(a);

        int[][] b = new int[2][];
        printArray(b);
        b[0] = new int[2];
        b[1] = new int[3];
        printArray(b);

        int[] nums = {1, 1, 3, 2, 2, 3, 2, 2};
        int[] buc = new int[nums.length];

        for (int e : nums) {
            System.out.print(buc[e]++ + " ");
        }
    }


}
