package leetcode.practice;

public class LongestCommonPrefix {

  public static String longestCommonPrefix(String[] strs) {

    if (strs.length == 1) {
      return strs[0];
    }

    if (strs[0].length() == 0) {
      return "";
    }

    StringBuilder strPrefix = new StringBuilder();
    int prefixIdx = -1;


    for (int i = 1; i < strs.length; i++) {
      prefixIdx++;
      strPrefix.append(strs[0].charAt(prefixIdx));
      if (!strs[i].startsWith(strPrefix.toString())) {
        if (strPrefix.toString().length() > 1) {
          return strPrefix.substring(0, prefixIdx - 1);
        } else {
          return "";
        }
      }
    }
    return strPrefix.toString();
  }

  public static void main(String[] args) {
    System.out.println(longestCommonPrefix(new String [] {"flower","flow","flight"}));
    System.out.println(longestCommonPrefix(new String [] {"dog","racecar","flight"}));
    System.out.println(longestCommonPrefix(new String [] {"a"}));
    System.out.println(longestCommonPrefix(new String [] {"abc", "abc"}));
  }


  public String longestCommonPrefixChatGPT(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    int n = strs.length;
    int prefixLen = 0;
    boolean done = false;
    while (!done) {
      if (prefixLen >= strs[0].length()) {
        break;
      }
      char c = strs[0].charAt(prefixLen);
      for (int i = 1; i < n; i++) {
        if (prefixLen >= strs[i].length() || strs[i].charAt(prefixLen) != c) {
          done = true;
          break;
        }
      }
      if (!done) {
        prefixLen++;
      }
    }
    return strs[0].substring(0, prefixLen);

  }
}
