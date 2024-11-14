package takeuforward.blind75leetcodeproblems.string;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (s.charAt(i) == ')' && stack.peek().equals('(')
                        || (s.charAt(i) == ']' && stack.peek().equals('['))
                        || (s.charAt(i) == '}' && stack.peek().equals('{'))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
