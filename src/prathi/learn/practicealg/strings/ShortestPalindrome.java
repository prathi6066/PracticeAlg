package prathi.learn.practicealg.strings;

public class ShortestPalindrome {

    public static void main(String[] args) {
        System.out.println(shortestPalindromes("abcd"));
    }

    private static String shortestPalindromes(String s) {

        if (s.length() == 0 || s.length() == 1)
            return s;

        int n = s.length();
        int mid = n/2 ;
        int start = mid - 2;
        int end;
        if (n %2 == 0)
            end = mid;
        else
            end = mid + 1;

        while (s.charAt(start) == s.charAt(end) && end < s.length() && start > 0) {
            start--;
            end++;
        }

        StringBuilder temp = new StringBuilder();
        if (start == 0 && end < s.length()) {
            temp.append(s.substring(end + 1, s.length()));
            temp.reverse();
        } else if (start != 0 && end < s.length()){
            temp.append(s.substring(1, s.length()));
            temp.reverse();
        }

        if (temp.length() != 0) {
            return temp.toString() + s;
        }

        return s;
    }
}
