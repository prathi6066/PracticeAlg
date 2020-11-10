package prathi.learn.practicealg.strings;

import java.util.HashMap;

public class VerifyAnAlienDict {

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i =0;i<order.length();i++) {
            map.put(order.charAt(i), i);
        }

        for (int i=1; i< words.length; i++) {

            if (map.get(words[i].charAt(0)) == map.get(words[i-1].charAt(0))) {
                boolean isSorted = isSortedBasedOnOrder(map, words[i-1], words[i]);
                if(!isSorted)
                    return false;

            } else if(map.get(words[i].charAt(0)) < map.get(words[i-1].charAt(0))) {
                return false;
            }
        }

        return true;

    }

    private static boolean isSortedBasedOnOrder(HashMap<Character, Integer> map, String word1, String word2) {
        int len = Math.min(word1.length(), word2.length());
        for (int i = 0;i < len;i++) {
            if (map.get(word1.charAt(i)) > map.get(word2.charAt(i)))
                return false;
        }

        return word1.length() <= word2.length();
    }
}
