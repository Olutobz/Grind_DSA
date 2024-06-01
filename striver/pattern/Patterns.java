package pattern;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 01, June 2024
 * EMAIL: damexxey94@gmail.com
 */
public class Patterns {

    public static void main(String[] args) {
        pattern1();
        System.out.println("______________________________________");
        pattern2();
        System.out.println("______________________________________");
    }

    static void pattern1() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern2() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
