package prathi.learn.practicealg.strings;

public class ValidPalindromeII {

    public static void main(String[] args) {
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public static boolean validPalindrome(String s) {

        int i = 0;
        int j = s.length()-1;
        boolean canDelete = true;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return isPalindrome(s, i, j-1) || isPalindrome(s, i+1, j);
            }
        }

        return true;

    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j ) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
