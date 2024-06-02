package pattern;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 01, June 2024
 * EMAIL: damexxey94@gmail.com
 */
public class Patterns {

    public static void main(String[] args) {
        rectangularStarPattern();
        System.out.println("___________________________");
        rightAngledTrianglePattern();
        System.out.println("___________________________");
        rightAngledNumberPyramid();
        System.out.println("___________________________");
        rightAngledNumberPyramidII();
        System.out.println("___________________________");
        invertedRightPyramid();
        System.out.println("___________________________");
        invertedNumberedRightPyramid();
        System.out.println("___________________________");

    }

    static void rectangularStarPattern() {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void rightAngledTrianglePattern() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void rightAngledNumberPyramid() {
        for (int i = 1; i <= 5; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void rightAngledNumberPyramidII() {
        for (int i = 1; i <= 5; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void invertedRightPyramid() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 5; j > i; --j) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void invertedNumberedRightPyramid() {
        for (int i = 5; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
