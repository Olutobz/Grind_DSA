package bloomberg;

import java.util.Scanner;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 03 December 2023
 * EMAIL: damexxey94@gmail.com
 */

public class The3NPlusOne {

    private void ThreeNPlus1() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int res = 1;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (3 * n) + 1;
            }
            res++;
        }
        System.out.println(res);
    }

}
