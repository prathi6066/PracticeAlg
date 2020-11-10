package prathi.learn.practicealg.patterns.slidingwindow;

import java.util.HashMap;

public class StringPermutaion {

    /*
    Given a string and a pattern, find out if the string contains any permutation of the pattern.

    Input: String="oidbcaf", Pattern="abc"
    Output: true
    Explanation: The string contains "bca" which is a permutation of the given pattern.

    Time: O(N+M) where ‘N’ and ‘M’ are the number of characters in the input string and the pattern respectively.
    Space: O(M)
     */

    public static boolean findPermutation(String str, String pattern) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char p: pattern.toCharArray()) {
            map.put(p, map.getOrDefault(p, 0)+1);
        }

        int start = 0;
        int matches = 0;

        for(int end = 0; end<str.length(); end++) {

            if (map.containsKey(str.charAt(end))) {
                map.put(str.charAt(end), map.get(str.charAt(end))-1);

                if (map.get(str.charAt(end)) == 0)
                    matches++;

            }

            if (matches == map.size()) {
                return true;
            }
            if (end >= pattern.length() -1) {
                if (map.containsKey(str.charAt(start))) {
                    if (map.get(str.charAt(start)) == 0)
                        matches--;
                    map.put(str.charAt(start), map.get(str.charAt(start)) + 1);
                }
                start++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutaion.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutaion.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutaion.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutaion.findPermutation("aaacb", "abc"));
    }
}
