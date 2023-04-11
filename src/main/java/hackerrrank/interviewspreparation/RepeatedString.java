package hackerrrank.interviewspreparation;

public class RepeatedString {

  public static long repeatedString(String s, long n) {
    int originalLength = s.length();
    long a = 0L;
    for (int i = 0; i < originalLength; i++) {
      if (s.charAt(i) == 'a') {
        a++;
      }
    }

    if (n % originalLength == 0) {
      return a * n / originalLength;
    } else {
      int trash = (int) (n % originalLength);
      a = a * n / originalLength;

      for (int i = trash-1; i < originalLength; i++) {
        if (s.charAt(i) == 'a') {
          a++;
        }
      }
    }
    return a;
  }

  public static long countAs(String s, long n) {
    long count = 0;
    long fullRepeats = n / s.length();
    long remainingChars = n % s.length();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'a') {
        count += fullRepeats;
        if (i < remainingChars) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println("A's: " +
        repeatedString("epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq",
            549382313570L));
  }

}
