package pattern;

import java.awt.*;

/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 01, June 2024
 * EMAIL: damexxey94@gmail.com
 */

public class Patterns {

    public static void main(String[] args) {
        rectangularStarPattern();
        lineSeparator();
        rightAngledTrianglePattern();
        lineSeparator();
        rightAngledNumberPyramid();
        lineSeparator();
        rightAngledNumberPyramidII();
        lineSeparator();
        invertedRightPyramid();
        lineSeparator();
        invertedNumberedRightPyramid();
        lineSeparator();
        starPyramid();
        lineSeparator();
        invertedStarPyramid();
        lineSeparator();
        diamondStarPattern();
        lineSeparator();
        halfDiamondStarPattern();
        lineSeparator();
        binaryNumberTrianglePattern();
        lineSeparator();
        numberCrownPattern();
        lineSeparator();
        increasingNumberTrianglePattern();
        lineSeparator();
        increasingLetterTrianglePattern();
        lineSeparator();
        reverseLetterTrianglePattern();
        lineSeparator();
        alphaRampPattern();
        lineSeparator();
        alphaHillPattern();
        lineSeparator();
        alphaTrianglePattern();
        lineSeparator();
        symmetricVoidPattern();
        lineSeparator();
        symmetricButterflyPattern();
        lineSeparator();
        hollowRectanglePattern();
        lineSeparator();
    }

    private static void lineSeparator() {
        System.out.println("---------------------");
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
            for (int j = 1; j <= (2 * i - 1); ++j) {
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
            for (int j = 1; j <= (2 * i - 1); ++j) {
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
                System.out.print("* ");
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

    private static void numberCrownPattern() {
        for (int i = 1; i <= 4; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j);
            }
            int spaces = 2 * (4 - i);
            for (int j = 1; j <= spaces; ++j) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; --j) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private static void increasingNumberTrianglePattern() {
        int count = 1;
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print(count + " ");
                ++count;
            }
            System.out.println();
        }
    }

    private static void increasingLetterTrianglePattern() {
        for (int i = 0; i < 5; ++i) {
            for (char ch = 'A'; ch <= 'A' + i; ++ch) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    private static void reverseLetterTrianglePattern() {
        for (int i = 5; i > 0; --i) {
            for (char ch = 'A'; ch < 'A' + i; ++ch) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    private static void alphaRampPattern() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print((char) ('A' + i) + " ");
            }
            System.out.println();
        }
    }

    private static void alphaHillPattern() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 5 - i; j > 0; --j) {
                System.out.print(" ");
            }
            for (char ch = 'A'; ch <= 'A' + i; ++ch) {
                System.out.print(ch);
            }
            for (char ch = (char) ('A' + i - 1); ch >= 'A'; --ch) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    private static void alphaTrianglePattern() {
        char startChar = (char) ('A' + 5 - 1);
        for (int i = 0; i < 5; i++) {
            char currentChar = (char) (startChar - i);
            for (char ch = currentChar; ch <= startChar; ++ch) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    private static void symmetricVoidPattern() {
        int spaces = 0;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4 - i; ++j) {
                System.out.print("*");
            }
            for (int j = 0; j < spaces; ++j) {
                System.out.print(" ");
            }
            for (int j = 0; j < 4 - i; ++j) {
                System.out.print("*");
            }
            spaces += 2;
            System.out.println();
        }

        spaces = 2 * 4 - 2;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print("*");
            }
            for (int j = 0; j < spaces; ++j) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; ++j) {
                System.out.print("*");
            }
            spaces -= 2;
            System.out.println();
        }
    }

    private static void symmetricButterflyPattern() {
        int spaces = 2 * 4 - 2;
        for (int i = 1; i <= 2 * 4 - 1; ++i) {
            int stars = i;
            if (i > 3) {
                stars = 2 * 4 - i;
            }
            for (int j = 1; j <= stars; ++j) {
                System.out.print("*");
            }

            for (int j = 1; j <= spaces; ++j) {
                System.out.print(" ");
            }

            for (int j = 1; j <= stars; ++j) {
                System.out.print("*");
            }
            System.out.println();
            if (i < 4) spaces -= 2;
            else spaces += 2;
        }
    }

    private static void hollowRectanglePattern() {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (i == 0 || i == 4 - 1 || j == 0 || j == 4 - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
