package pattern;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 01, June 2024
 * EMAIL: damexxey94@gmail.com
 */
public class Patterns {

    public static void main(String[] args) {
        rectangularStarPattern();
        showEndOfLineDash();
        rightAngledTrianglePattern();
        showEndOfLineDash();
        rightAngledNumberPyramid();
        showEndOfLineDash();
        rightAngledNumberPyramidII();
        showEndOfLineDash();
        invertedRightPyramid();
        showEndOfLineDash();
        invertedNumberedRightPyramid();
        showEndOfLineDash();
        starPyramid();
        showEndOfLineDash();
        invertedStarPyramid();
        showEndOfLineDash();
        diamondStarPattern();
        showEndOfLineDash();
        halfDiamondStarPattern();
        showEndOfLineDash();
        binaryNumberTrianglePattern();
        showEndOfLineDash();

    }

    private static void showEndOfLineDash() {
        System.out.println("___________________");
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

    private static void halfDiamondStarPattern() {
        for (int i = 1; i <= 2 * 4 - 1; ++i) {
            int stars = i;
            if (i > 3) {
                stars = 2 * 4 - i;
            }
            for (int j = 1; j <= stars; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void binaryNumberTrianglePattern() {
        int start;
        for (int i = 0; i < 5; ++i) {
            if (i % 2 == 0) start = 1;
            else start = 0;
            for (int j = 0; j <= i; ++j) {
                System.out.print(start + " ");
                start = 1 - start;
            }
            System.out.println();
        }
    }

}
