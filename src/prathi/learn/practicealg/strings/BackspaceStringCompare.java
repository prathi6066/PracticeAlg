package prathi.learn.practicealg.strings;

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("a#c", "b"));
    }

    public static boolean backspaceCompare(String S, String T) {

        String s = removeBackSpaceString(S);
        String t = removeBackSpaceString(T);
        return s.equals(t);

    }

    private static String removeBackSpaceString(String s) {

        StringBuilder result = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else {
                if (!stack.isEmpty())
                    stack.pop();
            }
        }
        while(!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
