package leetcode.practice;

/*Given a string s which consists of lowercase or uppercase letters,
return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
*/

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

  public int longestPalindrome(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }

    int length = 0;
    boolean isOod = false;

    for (int frequency : map.values()) {
      if ( frequency > 1) {
        length += frequency / 2 * 2;
      }
      if (frequency % 2 > 0) {
        isOod = true;
      }
    }

    if (isOod) {
      length++;
    }

    return length;
  }

  public static void main(String[] args) {
    LongestPalindrome longestPalindrome = new LongestPalindrome();
    System.out.println(longestPalindrome.longestPalindrome("abccccdd"));
  }
}
