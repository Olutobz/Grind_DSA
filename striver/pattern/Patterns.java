package pattern;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 01, June 2024
 * EMAIL: damexxey94@gmail.com
 */
public class Patterns {

    public static void main(String[] args) {
        rectangularStarPattern();
        System.out.println("___________________");
        rightAngledTrianglePattern();
        System.out.println("___________________");
        rightAngledNumberPyramid();
        System.out.println("___________________");
        rightAngledNumberPyramidII();
        System.out.println("___________________");
        invertedRightPyramid();
        System.out.println("___________________");
        invertedNumberedRightPyramid();
        System.out.println("___________________");
        starPyramid();
        System.out.println("___________________");
        invertedStarPyramid();
        System.out.println("___________________");
        diamondStarPattern();

    }

    private static void rectangularStarPattern() {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void rightAngledTrianglePattern() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void rightAngledNumberPyramid() {
        for (int i = 1; i <= 5; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void rightAngledNumberPyramidII() {
        for (int i = 1; i <= 5; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void invertedRightPyramid() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 5; j > i; --j) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void invertedNumberedRightPyramid() {
        for (int i = 5; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void starPyramid() {
        for (int i = 1; i <= 5; ++i) {
            for (int j = 5 - i; j > 0; --j) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); ++k) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void invertedStarPyramid() {
        for (int i = 5; i >= 1; --i) {
            for (int j = 5 - i; j > 0; --j) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); ++k) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void diamondStarPattern() {
        starPyramid();
        invertedStarPyramid();
    }

}
