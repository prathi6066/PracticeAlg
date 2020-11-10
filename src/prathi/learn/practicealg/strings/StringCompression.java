package prathi.learn.practicealg.strings;

public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }

    public static int compress(char[] chars) {

        int start = 0;
        int count = 1;
        char prev = chars[0];
        for (int i=1;i<chars.length;i++) {
            if (chars[i] == prev) {
                count++;
            } else {
                chars[start++] = prev;
               if (count != 1) {
                   char[] c = Integer.toString(count).toCharArray();
                   for (char s : c) {
                       chars[start++] = s;
                   }
               }
               count = 1;
               prev = chars[i];

            }
        }

        chars[start++] = prev;
        if (count > 1) {
            char[] c = Integer.toString(count).toCharArray();
            for (char s: c) {
                chars[start++] = s;
            }
        }

        return start;

    }
}
