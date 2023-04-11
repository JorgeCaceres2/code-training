package leetcode.assessment1;

public class IntegerPalindrome {

  public static boolean isPalindrome (int x) {
    String originalString = String.valueOf(x);
    StringBuilder reversedString = new StringBuilder();

    for (int i = originalString.length() - 1; i >= 0 ; i--) {
      reversedString.append(originalString.charAt(i));
    }


    return originalString.equals(reversedString.toString());

  }

  public static void main(String[] args) {
    int num = 121;

    System.out.println(isPalindrome(num));
    System.out.println();
  }

}
