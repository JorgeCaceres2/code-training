package leetcode.practice;

public class IndexOfTheFirstOccurrence {

  public static int solution (String haystack, String needle) {

    int needleLength = needle.length();
    for (int i = 0; i <= haystack.length() - needleLength; i++ ) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        String aux = haystack.substring(i, i + needleLength);
        if (aux.equals(needle)) {
          return i;
        }
      }
    }
    return -1;

  }

  public static void main(String[] args) {
    System.out.println(solution("sadbutsad", "sad"));
    System.out.println(solution("leetcode", "leeto"));
    System.out.println(solution("hello", "ll"));
    System.out.println(solution("a", "a"));


  }

}
