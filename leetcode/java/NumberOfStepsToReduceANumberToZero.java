package java;

public class NumberOfStepsToReduceANumberToZero {
    // TC -> O(Log(num), SC -> O(1)
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            steps++;
        }
        return steps;
    }
}
