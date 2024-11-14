package takeuforward.blind75leetcodeproblems.binary;

public class NumberOf1Bits {

    public static int hammingWeight (int n) {
        int result = 0;
        while (n > 0) {
            result = result + n % 2;
            n = n >> 1;
        }
        return result;
    }

    public static int hammingWeight2 (int n) {
        int result = 0;
        while (n > 0) {
            n = n & (n - 1);
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Result: " + hammingWeight(2147483645));
        System.out.println("Result: " + hammingWeight2(2147483645));
    }
}
