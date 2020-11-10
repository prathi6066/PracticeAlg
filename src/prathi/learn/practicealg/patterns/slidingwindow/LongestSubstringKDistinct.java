package prathi.learn.practicealg.patterns.slidingwindow;

import java.util.HashMap;

public class LongestSubstringKDistinct {

    /*
    Given a string, find the length of the longest substring in it with no more than K distinct characters.

    Input: String="araaci", K=2
    Output: 4
     Explanation: The longest substring with no more than '2' distinct characters is "araa".

     Time: O(N). Space: O(K)
     */

    public static int findLength(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        int len = 0;

        for (int end = 0;end < str.length(); end++) {
            if (map.containsKey(str.charAt(end))) {
                int val = map.get(str.charAt(end));
                map.put(str.charAt(end), val+1);
            } else {
                map.put(str.charAt(end), 1);
            }
            while(map.size() > k) {
                int val = map.get(str.charAt(start));
                if (val == 1) {
                    map.remove(str.charAt(start));
                } else {
                    map.put(str.charAt(start), val-1);
                }
                start++;
            }

            len = Math.max(len, end - start + 1);
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
