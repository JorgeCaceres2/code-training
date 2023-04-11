package leetcode.flags;

//Given a string s, find the length of the longest substring without repeating characters.


import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

  public int lengthOfLongestSubstringSolution(String s) {
    Set<Character> set = new HashSet<>();
    int i = 0, j = 0, maxLen = 0;
    while (j < s.length()) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j));
        j++;
        maxLen = Math.max(maxLen, j - i);
      } else {
        set.remove(s.charAt(i));
        i++;
      }
    }
    return maxLen;
  }

  public static int lengthOfLongestSubstring(String s) {

    int longest = 0;
    for (int i = 0; i < s.length() - 2; i++) {
      int currentLongest;

      //get char index
      char actualChar = s.charAt(i);
      //get subString starting from i to length
      String leftString = s.substring(i+1);

      //see if char exists again
      int leftStringLength = leftString.indexOf(actualChar);

      //if not exists - the length is the end of the substring + 1
      if (leftStringLength < 0) {
        currentLongest = leftString.length();

      } else if (leftStringLength == 0) {
        currentLongest = 1;

        //otherwise -  the length is the index of the next occurrence
      } else {
        currentLongest = leftStringLength + 1;
      }
      longest = Math.max(longest, currentLongest);
    }
    return longest;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("pwwkew"));
  }

}
