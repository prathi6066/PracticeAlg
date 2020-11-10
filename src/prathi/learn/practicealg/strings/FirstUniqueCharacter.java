package prathi.learn.practicealg.strings;

import java.util.HashMap;

public class FirstUniqueCharacter {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    static class Pair {
        int index, count = 0;
        Pair(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public static int firstUniqChar(String s) {
        if (s.length() == 0)
            return -1;
        HashMap<Character, Pair> map = new HashMap<>();

        for (int i = 0;i <s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                int count = map.get(s.charAt(i)).count;
                Pair p = new Pair(map.get(s.charAt(i)).index, count+1);
                map.put(s.charAt(i), p);
            } else {
                Pair p = new Pair(i, 1);
                map.put(s.charAt(i), p);
            }
        }

        int result = -1;
        for (char c: map.keySet()) {
            if (map.get(c).count == 1 && map.get(c).index < result) {
                result = map.get(c).index;
            }
        }

        return (result==s.length())? -1 : result;

    }
}
