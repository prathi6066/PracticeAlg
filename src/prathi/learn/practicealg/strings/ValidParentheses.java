package prathi.learn.practicealg.strings;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {

        if (s == "")
            return true;

        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c == '(' || c =='{' || c =='[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char currentChar = stack.pop();
                if (!((currentChar == '(' && c == ')') || (currentChar == '{' && c == '}') || (currentChar == '[' && c == ']'))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}