public class AddDigits {
    // TC -> O(log(num)), SC -> O(1)
    public int addDigits(int num) {
        if (num == 0) return 0;
        while (num > 9) {
            num = num / 10 + num % 10;
        }
        return num;
    }

    // TC -> O(1), SC -> O(1)
    public int addDigitsII(int num) {
        if (num == 0) return 0;
        return num % 9 == 0 ? 9 : num % 9;
    }
}
