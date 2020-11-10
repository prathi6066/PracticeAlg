package prathi.learn.practicealg.strings;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }


    public static boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!Character.isAlphabetic(s.charAt(start)) && !Character.isDigit(s.charAt(start))) {
                start++;
                continue;
            }
            if (!Character.isAlphabetic(s.charAt(end)) && !Character.isDigit(s.charAt(end))) {
                end--;
                continue;
            }

            if (start < end) {
                if (Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--)))
                    return false;
            }
        }

        return true;

    }
}
