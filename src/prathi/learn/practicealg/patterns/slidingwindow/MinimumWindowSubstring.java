package prathi.learn.practicealg.patterns.slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public static String findSubstring(String str, String pattern) {

        /*
        Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.
        Input: String="aabdec", Pattern="abc"
        Output: "abdec"
        Explanation: The smallest substring having all characters of the pattern is "abdec"

        Time: O(N+M)
        space: O(M)
         */

        HashMap<Character, Integer> map = new HashMap<>();
        for (char p: pattern.toCharArray()) {
            map.put(p, map.getOrDefault(p, 0)+1);
        }

        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int minStartIndex = 0;
        int matches = 0;

        for (int end = 0;end<str.length();end++) {
            char rightChar = str.charAt(end);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar)-1);
                if(map.get(rightChar) >=0)
                    matches++;
            }

            while (matches == pattern.length()) {
                if (minLength >= (end-start+1)) {
                    minLength = end-start+1;
                    minStartIndex = start;
                }

                char leftChar = str.charAt(start++);
                if(map.containsKey(leftChar)) {
                    if(map.get(leftChar) == 0)
                        matches--;
                    map.put(leftChar, map.get(leftChar)+1);
                }
            }

        }
        return (minLength == Integer.MAX_VALUE) ? "" : str.substring(minStartIndex, minLength+minStartIndex);
    }

    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("abdbca", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
    }
}
