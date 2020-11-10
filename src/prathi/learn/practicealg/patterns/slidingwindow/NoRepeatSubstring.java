package prathi.learn.practicealg.patterns.slidingwindow;

import java.util.HashSet;

/*
   Given a string, find the length of the longest substring which has no repeating characters.

    Input: String="aabccbb"
     Output: 3
     Explanation: The longest substring without any repeating characters is "abc".

     Time: O(N) Space: O(K) K is the number of distinct characters in the input string.
 */
public class NoRepeatSubstring {

    public static int findLength(String str) {
        HashSet<Character> map = new HashSet<>();
        int len = 0;
        int start = 0;
        for (int end = 0;end<str.length();end++) {
            if (!map.contains(str.charAt(end))) {
                map.add(str.charAt(end));
                len = Math.max(len, end-start+1);
            } else {
                while(map.contains(str.charAt(end))) {
                    map.remove(str.charAt(start));
                    start++;
                }
                map.add(str.charAt(end));
                len = Math.max(len, end-start+1);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}
