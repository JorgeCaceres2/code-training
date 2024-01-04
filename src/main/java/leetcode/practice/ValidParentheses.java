package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {

  public static boolean isValid(String s) {
    List<Character> openBracesList = new ArrayList<>();
    char[] charArray = s.toCharArray();

    for (char c : charArray) {
      if (c == '(' || c == '{' || c == '[') {
        openBracesList.add(c);
      } else if (c == ')' && !openBracesList.isEmpty() &&'(' == openBracesList.get(openBracesList.size() - 1)) {
        openBracesList.remove(openBracesList.size() - 1);

      } else if (c == '}' &&  !openBracesList.isEmpty() &&'{' == openBracesList.get(openBracesList.size() - 1)) {
        openBracesList.remove(openBracesList.size() - 1);

      } else if (c == ']' && !openBracesList.isEmpty() && '[' == openBracesList.get(openBracesList.size() - 1)) {
        openBracesList.remove(openBracesList.size() - 1);
      } else {
        return false;
      }
    }
    return openBracesList.isEmpty();

  }


  private boolean chatGPTSolution (String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
        stack.pop();
      } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
        stack.pop();
      } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
        stack.pop();
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.print(isValid("({})"));
  }

}
