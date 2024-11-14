package takeuforward.blind75leetcodeproblems.string;

public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        int maxLength = 0, start = -1;

        for (int i = 0; i < s.length(); i++) {
            int length = Math.max(getLength(i, i, s), getLength(i, i + 1, s));
            if (maxLength < length) {
                maxLength = length;
                start = i - (length - 1) / 2;
            }
        }
        return s.substring(start, start + maxLength);
    }

    private static int getLength(int i, int j, String s) {
        if (j >= s.length()) {
            return 0;
        }
        int length = (i == j) ? -1 : 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            length += 2;
            i--;
            j++;
        }
        return length;
    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right) {
            return 0;
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println("1. Longest palindrome: " + longestPalindrome("babad"));
        System.out.println("2. Longest palindrome: " + longestPalindrome2("babad"));
    }
}
