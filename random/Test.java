
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[][] a = new int[2][4];
        print2DArrayContents(a);

        int[][] b = new int[2][];
        print2DArrayContents(b);
        b[0] = new int[2];
        b[1] = new int[3];
        print2DArrayContents(b);

        int[] nums = {1, 1, 3, 2, 2, 3, 2, 2};
        int[] buc = new int[nums.length];

        for (int e : nums) {
            System.out.print(buc[e]++ + " ");
        }
    }

    private static void print2DArrayContents(int[][] arr) {
        if (arr == null || arr.length == 0)
            return;

        for (int[] num : arr) {
            System.out.println(Arrays.toString(num));
        }

        for (int[] nums : arr) {
            if (nums != null) {
                for (int num : nums) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
        }
    }
}
