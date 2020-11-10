package prathi.learn.practicealg.patterns.slidingwindow;

import java.util.HashMap;

public class CharacterReplacement {

    /*
        Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.
        Input: String="aabccbb", k=2
        Output: 5
        Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".


        Time: 0(N) Space: O(k)
     */

    public static int findLength(String str, int k) {
        // TODO: Write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int len = 0;
        int freqCount = 0;

        for (int end = 0; end < str.length(); end++) {
            map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0)+1);
            freqCount = map.get(str.charAt(end));

            if (end - start + 1 - freqCount > k) {
                map.put(str.charAt(start), map.getOrDefault(str.charAt(start), 0)-1);
                if (map.get(str.charAt(start)) <= 0)
                    map.remove(str.charAt(start));
                start++;
            }

            len = Math.max(len, end-start+1);

        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}
