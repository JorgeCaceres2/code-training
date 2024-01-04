package leetcode.practice;

/*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
and removing all non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers./
 */
public class Palindrome {

  public boolean isPalindrome (String s) {
    s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

}
