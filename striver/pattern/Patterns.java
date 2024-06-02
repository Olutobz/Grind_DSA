package pattern;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 01, June 2024
 * EMAIL: damexxey94@gmail.com
 */
public class Patterns {

    public static void main(String[] args) {
        pattern1();
        System.out.println("___________________________");
        pattern2();
        System.out.println("___________________________");
        pattern3();
        System.out.println("___________________________");
        pattern4();
        System.out.println("___________________________");
        pattern5();
        System.out.println("___________________________");
        pattern6();
        System.out.println("___________________________");

    }

    static void pattern1() {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3() {
        for (int i = 1; i <= 5; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern4() {
        for (int i = 1; i <= 5; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void pattern5() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 5; j > i; --j) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern6() {
        for (int i = 5; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
