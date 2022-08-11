package test;

import java.util.Arrays;

public class Test {

    public static void printArray(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        /* for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
           }
        *  */

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; arr[i] != null && j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
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

    }

}
