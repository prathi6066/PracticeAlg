package prathi.learn.practicealg.strings;

public class ConsecutiveCharacters {

    public static int maxPower(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int start = 0;
        int next = 0;
        int length = 0;
        while (start < s.length() && next < s.length()) {
            if (s.charAt(start) == s.charAt(next)) {
                next++;
            } else {
                int diff = next - start;
                length = Math.max(length, diff);
                start = next;
            }
        }

        if(next != start) {
            int diff = next - start;
            length = Math.max(length, diff);
        }

        return length;
    }

    public static void main(String[] args) {
        int res = maxPower("hooraaaaaaaaaaay");
        System.out.println(res);
    }
}
