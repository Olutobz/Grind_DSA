public class CountOperationsToObtainZero {
    // TC -> O(Log(min(num1,num2)), SC -> O(1)
    public int countOperations(int num1, int num2) {
        int steps = 0;
        if (num1 < 0 || num2 < 0) return 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            steps++;
        }
        return steps;
    }
}
