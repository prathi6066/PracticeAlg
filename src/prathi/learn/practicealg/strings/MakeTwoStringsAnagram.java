package prathi.learn.practicealg.strings;

public class MakeTwoStringsAnagram {

    public static void main(String[] args) {
        System.out.println(minSteps("leetcode","practice"));
    }

    public static int minSteps(String s, String t) {
        if (s == null || t == null || s.length() != t.length() || s.equals(t))
            return 0;
        int[] countStr = new int[26];

        for (char c: s.toCharArray()) {
            int value = countStr[c - 'a'];
            countStr[c-'a'] = ++value;
        }

        for (char c: t.toCharArray()) {
            int value = countStr[c - 'a'];
            countStr[c-'a'] = --value;
        }
        int result = 0;
        for (int i: countStr) {
            if (i > 0) {
                result+=i;
            }
        }

        return result;
    }
}
