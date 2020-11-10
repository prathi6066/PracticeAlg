package prathi.learn.practicealg.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumRemoveToMakeValidString {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid(""));
    }

    private static class StringVal {
        private int indexVal;
        private char c;

        StringVal(int indexVal, char c) {
            this.indexVal = indexVal;
            this.c = c;
        }
    }
    private static String minRemoveToMakeValid(String s) {
        List<Integer> indexToBeRemoved = new ArrayList<>();
        Stack<StringVal> stack = new Stack<>();

         for (int j=0; j< s.length(); j++) {
             if (s.charAt(j) == '(') {
                 stack.push(new StringVal(j, s.charAt(j)));
             } else if (s.charAt(j) == ')') {
                 if (!stack.isEmpty() && stack.peek().c == '(') {
                     stack.pop();
                 } else {
                     indexToBeRemoved.add(j);
                 }
             }
         }

         while(!stack.isEmpty()) {
             StringVal stringVal = stack.pop();
             indexToBeRemoved.add(stringVal.indexVal);
         }

         StringBuilder stringBuilder = new StringBuilder();
        for (int j=0; j< s.length(); j++) {
            if (!indexToBeRemoved.contains(j)) {
                stringBuilder.append(s.charAt(j));
            }
        }
        return  stringBuilder.toString();

    }
}
