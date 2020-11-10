package prathi.learn.practicealg.patterns.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringAnagrams {

    /*
    Given a string and a pattern, find all anagrams of the pattern in the given string.

    Input: String="ppqp", Pattern="pq"
    Output: [1, 2]
    Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".

    Time: O(N+M) where ‘N’ and ‘M’ are the number of characters in the input string and the pattern respectively.
    Space: O(M)
     */

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();

        int start = 0;
        int matches = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char p: pattern.toCharArray()) {
            map.put(p, map.getOrDefault(p, 0)+1);
        }

        for (int end = 0;end<str.length();end++) {
            char rightChar = str.charAt(end);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar)-1);

                if (map.get(rightChar) == 0)
                    matches++;
            }


            if (matches == map.size()) {
                resultIndices.add(start);
            }

            if (end >= pattern.length() -1) {
                char leftChar = str.charAt(start++);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0)
                        matches--;
                    map.put(leftChar, map.get(leftChar)+1);
                }
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}
