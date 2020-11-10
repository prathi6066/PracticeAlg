package prathi.learn.practicealg.strings;

import java.util.HashMap;

public class LengthOfLongestSubstringWithoutRepeating {

    //Input: "abcabcbb"
    //Output: 3
    //Explanation: The answer is "abc", with the length of 3.

    public static void main(String[] args) {
        System.out.println(findCountOfLongestSubWRCOptmized("jbpnbwwd"));
    }

    private static int findCountOfLongestSubWRC(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        int count = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+ 1);
                while (map.get(c) != 1) {
                    char r = s.charAt(start);
                    int cVal = map.get(r);
                    if (cVal == 1)
                        map.remove(s.charAt(start));
                    else
                        map.put(s.charAt(start), --cVal);
                    start++;
                }
            } else {
                map.put(c, 1);
                count = Math.max(count, map.size());
            }
        }
        return count;

    }

    private static int findCountOfLongestSubWRCOptmized(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        int count = 0;
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)), start);
            }
            count = Math.max(count, end-start + 1);
            map.put(s.charAt(end), end +1);
        }
        return count;

    }
}
