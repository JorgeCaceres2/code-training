package leetcode.assessment1;

public class SumIntegersAsString {

  public static String addStrings(String num1, String num2) {
    /*
    *  192
    *   12
    *
    * */

    StringBuilder result = new StringBuilder();
    int idx1 = num1.length() - 1;
    int idx2 = num2.length() - 1;
    int majorIdx = idx1 - idx2 >= 0 ? idx1 : idx2;
    int add = 0;

    while (majorIdx >= 0 || add > 0) {
      String digit1 = idx1 >= 0 ? String.valueOf(num1.charAt(idx1)) : "0";
      String digit2 = idx2 >= 0 ? String.valueOf(num2.charAt(idx2)) : "0";
      int sum = Integer.parseInt(digit1) + Integer.parseInt(digit2) + add;
      if (sum >= 10) {
        result.append(String.valueOf(sum).charAt(1));
        add = 1;
      } else {
        result.append(sum);
        add = 0;
      }
      idx1--;
      idx2--;
      majorIdx--;

    }
    return result.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(addStrings("1", "9"));
  }
}
