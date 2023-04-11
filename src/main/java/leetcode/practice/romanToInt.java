package leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class romanToInt {

  public static int romanToInt(String s) {
    int result = 0;
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    for (int i = 0; i < s.length(); i++) {
      int currentNumber = map.get(s.charAt(i)); //iV
      int nextNumber;
      if (i <= s.length() - 2) {
        nextNumber = map.get(s.charAt(i + 1));

        //it's a minor/equal value than the next one - easy path
        if (currentNumber > nextNumber) {
          result += currentNumber;

          //it's minor
        } else {
          int subtractions = 0;
          while (currentNumber < nextNumber && i < s.length() -1) {
            subtractions += currentNumber;
            i++;
            currentNumber = map.get(s.charAt(i));

            if (i < s.length() -1) {
              nextNumber = map.get(s.charAt(i + 1));
            } else {
              nextNumber = -1;
            }
          }

          currentNumber = map.get(s.charAt(i));
          result += currentNumber - subtractions;


        }
      } else {
        result += currentNumber;

      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(romanToInt("IX"));
  }

  public static int romanToIntChatGPT(String s) {
    int result = 0;
    int prev = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      int current = romanValue(s.charAt(i));
      if (current < prev) {
        result -= current;
      } else {
        result += current;
      }
      prev = current;
    }
    return result;
  }

  public static int romanValue(char c) {
    return switch (c) {
      case 'I' -> 1;
      case 'V' -> 5;
      case 'X' -> 10;
      case 'L' -> 50;
      case 'C' -> 100;
      case 'D' -> 500;
      case 'M' -> 1000;
      default -> 0;
    };
  }
}
