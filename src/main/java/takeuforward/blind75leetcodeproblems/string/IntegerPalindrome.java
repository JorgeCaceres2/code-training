package takeuforward.blind75leetcodeproblems.string;

public class IntegerPalindrome {

    public static boolean isPalindrome (int n) {
        int copy = n;
        int revNum = 0;

        while (n > 0) {
            int rest = n % 10;
            revNum = (revNum * 10) + rest;
            n = n / 10;
        }
        return copy == revNum;
    }

    public static void main(String[] args) {
        int n = 121;
        System.out.println(n + " Is palindrome: " + isPalindrome(n));
    }
}
