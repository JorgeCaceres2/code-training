package tallerpaypal;

import java.util.Arrays;
import java.util.Collections;

public class Challenge {

    static void splitString3(String str, int parts) {
      if (str == null || str.isEmpty() || parts <= 0) {
        System.out.println("Error in given parameters, returning a empty list");
        System.out.println(Collections.emptyList());
        return;
      } else if (str.length() < parts) {
        System.out.println("Error in given parameters, returning a singleton list");
        System.out.println(Collections.singletonList(str));
        return;
      }

      int strLength = str.length();
      int characterQuantity = strLength / parts;
      int rest = strLength % parts;
      String[] resultArray = new String[parts];
      int idx = 0;
      for (int j = 0; j < strLength; j = j + characterQuantity) {
        if (rest > 0) {
          resultArray[idx++] = str.substring(j, j + characterQuantity + 1);
          rest--;
          j++;
        } else {
          resultArray[idx++] = str.substring(j, j + characterQuantity);
        }
      }

      Arrays.stream(resultArray).forEach(System.out::println);
    }

  static void splitString(String str, int parts) {


      if (str == null || str.isEmpty()) {
        System.out.println("Invalid string");
      } else {
        int quantity = str.length() / parts;
        int currentIdx = 0;
        for (int i = 0; i < parts; i++) {
          if (str.length() - currentIdx >= quantity) {
            System.out.println(str.substring(currentIdx, currentIdx + quantity));
            currentIdx = currentIdx + quantity;
          } else {
            System.out.println(str.substring(currentIdx));
          }
        }
      }
  }






    public static void main(String[] args) {
      String str = "abcdefghijklmnopqrstuvwxy"; //length 25
      int split_number = 5;
      splitString(str, split_number);

      System.out.println("-------");

      str = "abcfdefghijkl"; //length 13
      split_number = 3;
      splitString(str, split_number);

      System.out.println("-------");

      str = "abcfdefghi"; //length 10
      split_number = 2;
      splitString(str, split_number);

      System.out.println("-------");

      str = "abcdefgh";
      split_number = 3;
      splitString(str, split_number);

      System.out.println("-------");

      str = "ab";
      split_number = 3;
      splitString(str, split_number);

      System.out.println("-------");

      str = null;
      split_number = 3;
      splitString(str, split_number);

      System.out.println("-------");

      str = "abcd";
      split_number = 0;
      splitString(str, split_number);
    }
  }

/*
Write a Java program to divide a string in n equal parts.
The given string is: abcdefghijklmnopqrstuvwxy
The string divided into 5 parts and they are:
abcde
fghij
klmno
pqrst
uvwxy
*/

